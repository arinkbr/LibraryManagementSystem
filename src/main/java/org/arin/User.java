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
}
