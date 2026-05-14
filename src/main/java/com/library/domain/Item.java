package com.library.domain;

import lombok.*;

import java.util.Comparator;

@Getter
public abstract class Item {
    protected String title;
    @Setter
    protected Status status;
    protected String id;

    private static int nextId = 0;

    public Item(String title, Status status) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = status;
    }

    /**
     * Converts item data into CSV format
     * @return CSV formatted string containing item data
     */
    public abstract String toCSV();

    @AllArgsConstructor
    public static class itemComparator implements Comparator<Item> {
        private ItemCompareType itemCompareType;

        @Override
        public int compare(Item o1, Item o2) {
            return switch (itemCompareType) {
                case TITLE -> o1.getTitle().compareToIgnoreCase(o2.getTitle());
                case STATUS -> o1.getStatus().compareTo(o2.getStatus());
                case ID -> o1.getId().compareTo(o2.getId());
            };
        }
    }

    public enum ItemCompareType {
        TITLE,
        STATUS,
        ID
    }

    public enum Status {
        BORROWED,
        INSTORE,
        LOST
    }
}
