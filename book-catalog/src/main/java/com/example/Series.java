package com.example;

import java.util.ArrayList;
import java.util.List;

public class Series {
    public int id;
    public String name;
    public List<Book> books = new ArrayList();

    public Series(int id, String name) {
        this.id = id;
        this.name = name;
    }
}