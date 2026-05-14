package com.library.domain;

import lombok.*;

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

    public enum Status {
        BORROWED,
        INSTORE,
        LOST
    }
}
