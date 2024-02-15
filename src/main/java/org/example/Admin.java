package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Manga> catalog;

    public Admin(String username, String password) {
        super(username, password);
        this.catalog = new ArrayList<>();
    }

    public void addManga(Manga manga) {
        catalog.add(manga);
    }

    public void deleteManga(String title) {
        catalog.removeIf(manga -> manga.getTitle().equalsIgnoreCase(title));
    }

    public void displayAllManga() {
        catalog.forEach(System.out::println);
    }

    @Override
    public void displayMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Add Manga");
        System.out.println("2. Delete Manga");
        System.out.println("3. Display All Manga");
        System.out.println("4. Logout");
    }
}
