package com.example;

import java.util.List;

public class Utils {
    public static int nextId = 100;

    public static int generateId() {
        return nextId++;
    }

    public static String bookToJson(Book b) {
        String json = "{";
        json = json + "\"id\":" + b.id + ",";
        json = json + "\"title\":\"" + b.title + "\",";
        json = json + "\"genre\":\"" + b.genre + "\",";
        json = json + "\"price\":" + b.price + ",";
        json = json + "\"available\":" + b.available + ",";
        json = json + "\"author\":\"" + b.author + "\",";
        json = json + "\"seriesId\":" + b.seriesId;
        json = json + "}";
        return json;
    }

    public static String booksToJson(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < books.size(); ++i) {
            sb.append(bookToJson((Book)books.get(i)));
            if (i < books.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static String seriesToJson(Series s) {
        String json = "{";
        json = json + "\"id\":" + s.id + ",";
        json = json + "\"name\":\"" + s.name + "\",";
        json = json + "\"books\":" + booksToJson(s.books);
        json = json + "}";
        return json;
    }

    public static String seriesListToJson(List<Series> seriesList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < seriesList.size(); ++i) {
            sb.append(seriesToJson((Series)seriesList.get(i)));
            if (i < seriesList.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}