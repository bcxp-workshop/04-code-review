package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestApiTest {
    private static final int PORT = 4567;
    private static final String BASE_URL = "http://localhost:4567";

    @BeforeClass
    public static void startServer() throws Exception {
        Thread serverThread = new Thread(() -> {
            try {
                MainApp.main(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        serverThread.setDaemon(true);
        serverThread.start();
        boolean started = false;

        for(int i = 0; i < 30; ++i) {
            try {
                HttpURLConnection con = (HttpURLConnection)(new URL("http://localhost:4567/books")).openConnection();
                con.setRequestMethod("GET");
                con.connect();
                if (con.getResponseCode() < 500) {
                    started = true;
                    break;
                }
            } catch (Exception var4) {
                Thread.sleep(200L);
            }
        }

        if (!started) {
            throw new RuntimeException("Server konnte nicht gestartet werden");
        }
    }

    @AfterClass
    public static void stopServer() {
        MainApp.closeConnection();
    }

    private String httpGet(String path) throws Exception {
        URL url = new URL("http://localhost:4567" + path);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        return content.toString();
    }

    private String httpPost(String json) throws Exception {
        URL url = new URL("http://localhost:4567/books");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        return content.toString();
    }

    private String httpDelete(String path) throws Exception {
        URL url = new URL("http://localhost:4567" + path);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("DELETE");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        return content.toString();
    }

    @Test
    public void testGetBooks() throws Exception {
        String json = this.httpGet("/books");
        Assert.assertTrue(json.contains("Harry Potter und der Stein der Weisen"));
        Assert.assertTrue(json.contains("Die Farben der Magie"));
    }

    @Test
    public void testAddAndDeleteBook() throws Exception {
        String newBook = "{\"title\":\"TestREST\",\"genre\":\"Test\",\"price\":5.5,\"available\":true,\"author\":\"Resty\",\"seriesId\":-1}";
        String resp = this.httpPost(newBook);
        Assert.assertTrue(resp.contains("success"));
        String books = this.httpGet("/books");
        Assert.assertTrue(books.contains("TestREST"));
        int idx = books.indexOf("TestREST");
        int idStart = books.lastIndexOf("\"id\":", idx) + 5;
        int idEnd = books.indexOf(",", idStart);
        int id = Integer.parseInt(books.substring(idStart, idEnd).replaceAll("[^0-9]", ""));
        String delResp = this.httpDelete("/books/" + id);
        Assert.assertTrue(delResp.contains("success"));
    }

    @Test
    public void testGetSeries() throws Exception {
        String json = this.httpGet("/series");
        Assert.assertTrue(json.contains("Scheibenwelt"));
        Assert.assertTrue(json.contains("Harry Potter"));
    }

    @Test
    public void testGetSeriesById() throws Exception {
        String json = this.httpGet("/series/1");
        Assert.assertTrue(json.contains("Scheibenwelt"));
        Assert.assertTrue(json.contains("Die Farben der Magie"));
    }
}