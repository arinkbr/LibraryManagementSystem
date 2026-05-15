package com.library.domain;

import com.library.interfaces.Reportable;
import com.library.util.Constants;
import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class Library implements Reportable {
    private List<Item> items;
    private List<User> users;

    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    /**
     * Loads users and items from CSV files and initializes them into a library
     * @return A library containing the initialized users and item
     */
    public static Library init() {
        Library library = new Library();
        List<Item> items = library.getItems();
        List<User> users = library.getUsers();

        File itemsCSV = new File(Constants.ITEMS_CSV_PATH);
        File usersCSV = new File(Constants.USERS_CSV_PATH);

        try (Scanner scanner = new Scanner(itemsCSV)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                String itemType = elements[0];
                String itemTitle = elements[1];
                Item.Status itemStatus = Item.Status.valueOf(elements[2].toUpperCase());

                switch (itemType) {
                    case "book" -> items.add(new Book(itemTitle, itemStatus, elements[3], elements[4], elements[5]));
                    case "dvd" -> items.add(new DVD(itemTitle, itemStatus, elements[3], Integer.parseInt(elements[4])));
                    case "magazine" -> items.add(new Magazine(itemTitle, itemStatus, Integer.parseInt(elements[3]), elements[4]));
                    default -> throw new RuntimeException("Unknown item type: " + itemType);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Scanner scanner = new Scanner(usersCSV)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                String userType = elements[0];
                String userName = elements[1];

                switch (userType) {
                    case "student" -> users.add(new Student(userName));
                    case "teacher" -> users.add(new Teacher(userName));
                    case "admin" -> users.add(new Admin(userName));
                    default -> throw new RuntimeException("Unknown user type: " + userType);
                }
            }
        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }

        return library;
    }

    /**
     * Backups current users and items into two CSV files
     * @param actUser The user initiating the backup command
     */
    public void backup(User actUser) {
        if (!(actUser instanceof Admin)) {
            throw new RuntimeException("Only admins can backup library data");
        }

        File itemsBackupCSV = new File(Constants.ITEMS_BACKUP_CSV_PATH);
        File usersBackupCSV = new File(Constants.USERS_BACKUP_CSV_PATH);

        try (FileWriter fileWriter = new FileWriter(itemsBackupCSV)){
            for (Item item : items) {
                fileWriter.write(item.toCSV());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fileWriter = new FileWriter(usersBackupCSV)){
            for (User user : users) {
                fileWriter.write(user.toCSV());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Allows a user to borrow a specified item in the library
     * @param user The user requesting the item
     * @param item The item to be borrowed
     */
    public void borrowItem(User user, Item item) {
        if (!users.contains(user)) {
            throw new RuntimeException("User not found in the library");
        }

        if (!items.contains(item)) {
            throw new RuntimeException("Item not found in the library");
        }

        if (item.getStatus().equals(Item.Status.BORROWED)) {
            throw new RuntimeException("Item already borrowed");
        }

        if (user instanceof Student) {
            if (user.borrowedItems.size() >= Constants.MAX_BOOKS_STUDENT) {
                throw new RuntimeException("Student borrowing limit attained");
            }

            if (!(item instanceof Book)) {
                throw new RuntimeException("Student can only borrow books");
            }
        }

        if (user instanceof Teacher) {
            if (user.borrowedItems.size() >= Constants.MAX_ITEMS_TEACHER) {
                throw  new RuntimeException("Teacher borrowing limit achieved");
            }
        }

        user.getBorrowedItems().add(item);
        item.setStatus(Item.Status.BORROWED);
    }
}
