package com.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {


    private List<Item> items;
    private List<User> users;

    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    /**
     * Adds an item to the library
     * @param item item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * adds user to the library
     * @param user user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * allows a user to borrow an item
     * @param user user borrowing an item
     * @param item item being borrowed
     */
    public void borrowItem(User user, Item item) {

        if (!user.canBorrow(item)) {
            System.out.println("Borrowing not allowed.");
            return;
        }

        if (!item.getStatus().equalsIgnoreCase("In Store")) {
            System.out.println("Item is not available.");
            return;
        }

        user.borrowItem(item);

        item.setStatus("Borrowed");

        System.out.println("Item borrowed successfully.");
    }

    /**
     * searches item by title
     * @param title title to serach
     * @return list of matching items
     */
    public List<Item> searchByTitle(String title) {

        List<Item> results = new ArrayList<>();

        for (Item item : items) {

            if (item.getTitle().equalsIgnoreCase(title)) {
                results.add(item);
            }
        }

        return results;
    }

    /**
     * searches books by author
     * @param author author name to search
     * @return list of matching books
     */
    public List<Item> searchByAuthor(String author) {

        List<Item> results = new ArrayList<>();

        for (Item item : items) {

            if (item instanceof Book) {

                Book book = (Book) item;

                if (book.getAuthor().equalsIgnoreCase(author)) {
                    results.add(book);
                }
            }
        }

        return results;
    }

    /**
     * recursively searches for an item by title
     * @param title title of item to search
     * @param index current index in the list
     * @return item if found, otherwise null
     */
    public Item recursiveSearchByTitle(String title, int index) {

        if (index >= items.size()) {
            return null;
        }

        Item item = items.get(index);

        if (item.getTitle().equalsIgnoreCase(title)) {
            return item;
        }

        return recursiveSearchByTitle(title, index + 1);
    }
}
