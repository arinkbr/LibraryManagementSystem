package com.library.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class Student extends User {

    private static final int MAX_BOOKS = 5;

    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {

        if (!(item instanceof Book)) {
            return false;
        }

        return getBorrowedItems().size() < MAX_BOOKS;
    }
}
