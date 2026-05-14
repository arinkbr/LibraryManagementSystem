package com.library.domain;

import lombok.*;
import java.util.ArrayList;
import java.util.Comparator;
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

    @AllArgsConstructor
    public static class UserComparator implements Comparator<User> {
        private UserCompareType userCompareType;

        @Override
        public int compare(User o1, User o2) {
            return switch (userCompareType) {
                case NAME -> o1.getName().compareToIgnoreCase(o2.getName());
                case ID -> o1.getId().compareTo(o2.getId());
            };
        }
    }

    public enum UserCompareType {
        NAME,
        ID
    }
}
