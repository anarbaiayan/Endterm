package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Customer extends User {
    private List<Manga> catalog;

    public Customer(String username, String password, List<Manga> catalog) {
        super(username, password);
        this.catalog = catalog;
    }

    public void displayAllManga() {
        catalog.forEach(System.out::println);
    }

    public void searchManga(String title) {
        List<Manga> results = catalog.stream()
                .filter(manga -> manga.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("Manga not found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    public void buyManga(String title) {
        List<Manga> results = catalog.stream()
                .filter(manga -> manga.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("Manga not found.");
        } else {
            System.out.println("Buying: ");
            results.forEach(System.out::println);
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("User Menu:");
        System.out.println("1. Display All Manga");
        System.out.println("2. Search Manga");
        System.out.println("3. Buy Manga");
        System.out.println("4. Logout");
    }
}
