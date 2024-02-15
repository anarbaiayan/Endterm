package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Manga> catalog = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        // Seed some data
        catalog.add(new Manga("Naruto", "Masashi Kishimoto", 9.99));
        catalog.add(new Manga("One Piece", "Eiichiro Oda", 8.99));
        catalog.add(new Manga("Bleach", "Tite Kubo", 7.99));
        catalog.add(new Manga("My Hero Academia", "Kohei Horikoshi", 19.9));
        catalog.add(new Manga("Dragon Ball", "Akira Toriyama", 6.99));
        catalog.add(new Manga("Attack on Titan", "Hajime Isayama", 12.99));
        catalog.add(new Manga("Death Note", "Tsugumi Ohba", 10.99));
        catalog.add(new Manga("Fullmetal Alchemist", "Hiromu Arakawa", 11.99));
        catalog.add(new Manga("Tokyo Ghoul", "Sui Ishida", 13.99));
        catalog.add(new Manga("Demon Slayer: Kimetsu no Yaiba", "Koyoharu Gotouge", 14.99));
        catalog.add(new Manga("Black Clover", "Yūki Tabata", 9.99));
        catalog.add(new Manga("Hunter x Hunter", "Yoshihiro Togashi", 15.99));
        catalog.add(new Manga("Fairy Tail", "Hiro Mashima", 8.99));
        catalog.add(new Manga("One Punch Man", "ONE", 11.99));
        catalog.add(new Manga("Sword Art Online", "Reki Kawahara", 10.99));
        catalog.add(new Manga("JoJo's Bizarre Adventure", "Hirohiko Araki", 16.99));
        catalog.add(new Manga("Naruto: Shippuden", "Masashi Kishimoto", 10.99));
        catalog.add(new Manga("Dragon Ball Z", "Akira Toriyama", 7.99));
        catalog.add(new Manga("The Promised Neverland", "Kaiu Shirai", 12.99));
        catalog.add(new Manga("Neon Genesis Evangelion", "Yoshiyuki Sadamoto", 14.99));
        catalog.add(new Manga("Black Butler", "Yana Toboso", 9.99));
        catalog.add(new Manga("Haikyu!!", "Haruichi Furudate", 10.99));
        catalog.add(new Manga("Naruto: Boruto Next Generations", "Ukyō Kodachi", 11.99));
        catalog.add(new Manga("Assassination Classroom", "Yūsei Matsui", 13.99));
        catalog.add(new Manga("Blue Exorcist", "Kazue Kato", 8.99));
        catalog.add(new Manga("The Seven Deadly Sins", "Nakaba Suzuki", 9.99));
        catalog.add(new Manga("Tokyo Revengers", "Ken Wakui", 12.99));
        catalog.add(new Manga("Mob Psycho 100", "ONE", 11.99));

        System.out.println("Welcome to Manga Shop!");
        System.out.println("Are you an Admin or a User? (A/U): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("A")) {
            currentUser = new Admin("admin", "admin");
        } else if (userType.equalsIgnoreCase("U")) {
            currentUser = new Customer("user", "user", catalog);
        } else {
            System.out.println("Invalid option. Please enter A for Admin or U for User.");
        }


        while (true) {

            currentUser.displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

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
                case 4:
                    System.out.println("Logging out...");
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}