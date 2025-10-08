package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeriesRepository {
    public Connection conn;

    public SeriesRepository(Connection c) {
        this.conn = c;
    }

    public List<Series> getAllSeries() {
        List<Series> seriesList = new ArrayList();

        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SERIES");

            while(rs.next()) {
                Series s = new Series(rs.getInt("id"), rs.getString("name"));
                Statement stmt2 = this.conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM BOOK WHERE series_id = " + s.id);

                while(rs2.next()) {
                    Book b = new Book(rs2.getInt("id"), rs2.getString("title"), rs2.getString("genre"), rs2.getDouble("price"), rs2.getBoolean("available"), rs2.getString("author"), rs2.getInt("series_id"));
                    s.books.add(b);
                }

                seriesList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return seriesList;
    }

    public Series getSeriesById(int id) {
        Series s = null;

        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SERIES WHERE id = " + id);
            if (rs.next()) {
                s = new Series(rs.getInt("id"), rs.getString("name"));
                Statement stmt2 = this.conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM BOOK WHERE series_id = " + s.id);

                while(rs2.next()) {
                    Book b = new Book(rs2.getInt("id"), rs2.getString("title"), rs2.getString("genre"), rs2.getDouble("price"), rs2.getBoolean("available"), rs2.getString("author"), rs2.getInt("series_id"));
                    s.books.add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}