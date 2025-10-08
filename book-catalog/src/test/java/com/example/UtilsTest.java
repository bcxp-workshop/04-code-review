package com.example;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilsTest {
    @BeforeClass
    public static void setup() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb3;DB_CLOSE_DELAY=-1", "sa", "");
        RunScript.execute(conn, new FileReader("src/test/resources/data.sql"));
    }

    @Test
    public void testBookToJson() {
        Book b = new Book(1, "Test", "Genre", (double)1.0F, true, "Author", -1);
        String json = Utils.bookToJson(b);
        Assert.assertTrue(json.contains("\"title\":\"Test\""));
    }

    @Test
    public void testBooksToJson() {
        List<Book> books = new ArrayList();
        books.add(new Book(1, "A", "G", (double)1.0F, true, "X", -1));
        books.add(new Book(2, "B", "G", (double)2.0F, false, "Y", -1));
        String json = Utils.booksToJson(books);
        Assert.assertTrue(json.startsWith("["));
        Assert.assertTrue(json.endsWith("]"));
    }

    @Test
    public void testSeriesToJson() {
        Series s = new Series(1, "Reihe");
        s.books.add(new Book(1, "A", "G", (double)1.0F, true, "X", 1));
        String json = Utils.seriesToJson(s);
        Assert.assertTrue(json.contains("\"name\":\"Reihe\""));
        Assert.assertTrue(json.contains("\"books\":[{"));
    }
}