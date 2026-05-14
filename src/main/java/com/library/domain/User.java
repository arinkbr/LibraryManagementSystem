package com.library.domain;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class User {
    protected String name;
    protected List<Item> borrowedItems;
    protected String id;

    private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * Converts user data into CSV format
     * @return CSV formatted string containing user data
     */
    public abstract String toCSV();

    /**
     * Adds an item to the borrowed item list
     *
     * @param item item to borrow
     */
    public void borrowItem(Item item) {
        borrowedItems.add(item);
    }

    /**
     * Removes an item from the borrowed item list
     *
     * @param item item to return
     */
    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }

    /**
     * checks if the user can borrow the item
     * @param item item to check
     * @return true if allowed, false otherwise
     */
    public abstract boolean canBorrow(Item item);
}
