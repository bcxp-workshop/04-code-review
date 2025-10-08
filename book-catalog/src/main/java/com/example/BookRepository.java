package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public Connection conn;

    public BookRepository(Connection c) {
        this.conn = c;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList();

        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK");

            while(rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("genre"), rs.getDouble("price"), rs.getBoolean("available"), rs.getString("author"), rs.getInt("series_id"));
                books.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public void addBook(Book b) {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (" + b.id + ", '" + b.title + "', '" + b.genre + "', " + b.price + ", " + (b.available ? 1 : 0) + ", '" + b.author + "', " + b.seriesId + ")";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteBook(int id) {
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate("DELETE FROM BOOK WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Book> filterBooks(String genre, String author, Boolean available) {
        List<Book> books = new ArrayList();

        try {
            String sql = "SELECT * FROM BOOK WHERE 1=1";
            if (genre != null) {
                sql = sql + " AND genre = '" + genre + "'";
            }

            if (author != null) {
                sql = sql + " AND author = '" + author + "'";
            }

            if (available != null) {
                sql = sql + " AND available = " + (available ? "TRUE" : "FALSE");
            }

            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("genre"), rs.getDouble("price"), rs.getBoolean("available"), rs.getString("author"), rs.getInt("series_id"));
                books.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}
