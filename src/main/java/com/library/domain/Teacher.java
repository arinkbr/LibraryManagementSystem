package com.library.domain;

public class Teacher extends User {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String toCSV() {
        return "teacher," +
                getName() + "," +
                getId() + "\n";
    }
}
