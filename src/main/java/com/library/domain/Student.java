package com.library.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class Student extends User {
    public Student(int id, String name) {
        super(name);
    }

    @Override
    public String toCSV() {
        return "student," + id + "," + name;
    }
}
