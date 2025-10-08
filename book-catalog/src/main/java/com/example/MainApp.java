package com.example;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import org.h2.tools.RunScript;
import spark.Spark;

public class MainApp {
    public static Connection conn;

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:mem:books;DB_CLOSE_DELAY=-1", "sa", "");
            RunScript.execute(conn, new FileReader("src/main/resources/data.sql"));
            BookRepository bookRepo = new BookRepository(conn);
            SeriesRepository seriesRepo = new SeriesRepository(conn);
            BookController bookController = new BookController(bookRepo);
            SeriesController seriesController = new SeriesController(seriesRepo);
            bookController.setupRoutes();
            seriesController.setupRoutes();
            Spark.port(4567);
            System.out.println("Server läuft auf Port 4567");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
