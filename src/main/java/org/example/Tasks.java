package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Manga> catalog = new ArrayList<>();
    private static User currentUser;

    public static void tasks() {
        catalog.add(new Manga("Bleach", "Tite Kubo", 7.9));


        while (true) {
            System.out.println("Welcome to Manga Shop!");
            System.out.println("Are you an Admin or a User? (A/U): ");
            System.out.println("Exit(E)");
            String userType = scanner.nextLine();

            if (userType.equalsIgnoreCase("A")) {
                currentUser = new Admin("admin", "admin");
            } else if (userType.equalsIgnoreCase("U")) {
                currentUser = new Customer("user", "user", catalog);
            } else if (userType.equalsIgnoreCase("e")) {
                break;
            }

            while (true) {

                currentUser.displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                if ((choice == 4)){
                    break;
                }

                switch (choice) {
                    case 1:
                        if (currentUser instanceof Admin) {
                            System.out.println("Enter Manga title: ");
                            String title = scanner.nextLine();
                            System.out.println("Enter Manga author: ");
                            String author = scanner.nextLine();
                            System.out.println("Enter Manga price: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            ((Admin) currentUser).addManga(new Manga(title, author, price));
                        } else {
                            ((Customer) currentUser).displayAllManga();
                        }
                        break;
                    case 2:
                        if (currentUser instanceof Admin) {
                            System.out.println("Enter Manga title to delete: ");
                            String title = scanner.nextLine();
                            ((Admin) currentUser).deleteManga(title);
                        } else {
                            System.out.println("Enter Manga title to search: ");
                            String title = scanner.nextLine();
                            ((Customer) currentUser).searchManga(title);
                        }
                        break;
                    case 3:
                        if (currentUser instanceof Admin) {
                            ((Admin) currentUser).displayAllManga();
                        } else {
                            System.out.println("Enter Manga title to buy: ");
                            String title = scanner.nextLine();
                            ((Customer) currentUser).buyManga(title);

                        }
                        break;

                }
            }
        }
    }
}
