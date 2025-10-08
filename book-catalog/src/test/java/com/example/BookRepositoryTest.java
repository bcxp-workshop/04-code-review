package com.example;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookRepositoryTest {
    private static BookRepository repo;

    @BeforeClass
    public static void setup() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        RunScript.execute(conn, new FileReader("src/test/resources/data.sql"));
        repo = new BookRepository(conn);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = repo.getAllBooks();
        Assert.assertTrue(books.size() >= 4);
    }

    @Test
    public void testAddAndDeleteBook() {
        Book b = new Book(99, "Testbuch", "Test", 9.99, true, "Tester", -1);
        repo.addBook(b);
        List<Book> books = repo.getAllBooks();
        boolean found = false;

        for(Book book : books) {
            if (book.id == 99) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
        repo.deleteBook(99);
        books = repo.getAllBooks();
        found = false;

        for(Book book : books) {
            if (book.id == 99) {
                found = true;
                break;
            }
        }

        Assert.assertFalse(found);
    }

    @Test
    public void testFilterBooks() {
        List<Book> fantasyBooks = repo.filterBooks("Fantasy", (String)null, (Boolean)null);
        Assert.assertEquals(3L, (long)fantasyBooks.size());
        List<Book> availableBooks = repo.filterBooks((String)null, (String)null, true);
        Assert.assertEquals(3L, (long)availableBooks.size());
    }
}