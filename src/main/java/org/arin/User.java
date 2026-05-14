package org.arin;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private int id;
    private String name;
    private List<Item> borrowedItems;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * Adds an item to the borrowed item list
     * @param item item to borrow
     */
    public void borrowItem(Item item) {
        borrowedItems.add(item);
    }

    /**
     * Removes an item from the borrowed item list
     * @param item item to return
     */
    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }
}
