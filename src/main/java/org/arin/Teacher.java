package org.arin;

import lombok.*;

@Getter
@Setter
@ToString
public class Teacher extends User {

    private static final int MAX_ITEMS = 10;

    public Teacher(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {

        return getBorrowedItems().size() < MAX_ITEMS;
    }
}
