package org.example;

public class Manga {
    private String title;
    private String author;
    private double price;

    public Manga(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    // Other getters and setters

    @Override
    public String toString() {
        return "Manga: " +
                "title: " + title +
                ", author: " + author +
                ", price: $" + price;
    }
}

