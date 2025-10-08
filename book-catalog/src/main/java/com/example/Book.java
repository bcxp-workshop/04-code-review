package com.example;

public class Book {
    public int id;
    public String title;
    public String genre;
    public double price;
    public boolean available;
    public String author;
    public int seriesId;

    public Book(int id, String title, String genre, double price, boolean available, String author, int seriesId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.available = available;
        this.author = author;
        this.seriesId = seriesId;
    }
}