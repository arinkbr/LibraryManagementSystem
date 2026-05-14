package org.arin;

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
}
