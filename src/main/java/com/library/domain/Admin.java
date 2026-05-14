package com.library.domain;

public class Admin extends User {

    public Admin(String name) {
        super(name);
    }

    @Override
    public String toCSV() {
        return "admin," + id + "," + name;
    }
}
