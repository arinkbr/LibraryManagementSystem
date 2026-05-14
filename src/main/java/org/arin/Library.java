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
}
