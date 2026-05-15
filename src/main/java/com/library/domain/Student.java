package com.library.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class Student extends User {
    public Student(String name) {
        super(name);
    }

    @Override
    public String toCSV() {
        return "student," +
                getName() + "," +
                getId() + "\n";
    }
}
