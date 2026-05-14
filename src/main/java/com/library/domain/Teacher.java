package com.library.domain;

public class Teacher extends User {

    public Teacher(int id, String name) {
        super(name);
    }

    @Override
    public String toCSV() {
        return "teacher," + id + "," + name;
    }
}
