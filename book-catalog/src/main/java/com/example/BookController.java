package com.example;

import java.util.List;
import org.json.JSONObject;
import spark.Spark;

public class BookController {
    public BookRepository repo;

    public BookController(BookRepository r) {
        this.repo = r;
    }

    public void setupRoutes() {
        Spark.get("/books", (req, res) -> {
            String genre = req.queryParams("genre");
            String author = req.queryParams("author");
            String avail = req.queryParams("available");
            Boolean available = null;
            if (avail != null) {
                available = avail.equals("true");
            }

            List<Book> books;
            if (genre == null && author == null && available == null) {
                books = this.repo.getAllBooks();
            } else {
                books = this.repo.filterBooks(genre, author, available);
            }

            res.type("application/json");
            return Utils.booksToJson(books);
        });
        Spark.post("/books", (req, res) -> {
            JSONObject obj = new JSONObject(req.body());
            Book b = new Book(Utils.generateId(), obj.getString("title"), obj.getString("genre"), obj.getDouble("price"), obj.getBoolean("available"), obj.getString("author"), obj.optInt("seriesId", -1));
            this.repo.addBook(b);
            res.status(201);
            return "{\"success\":true}";
        });
        Spark.delete("/books/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            this.repo.deleteBook(id);
            return "{\"success\":true}";
        });
    }
}