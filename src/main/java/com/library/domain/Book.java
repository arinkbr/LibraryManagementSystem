package com.library.domain;

import lombok.*;

@Getter
public class Book extends Item {

    private String isbn;
    private String author;
    private String genre;

    public Book(String title, Status status, String isbn, String author, String genre) {
        super(title, status);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toCSV() {
        return "Book ID: " + getId() +
                "\nTitle: " + getTitle() +
                "\nStatus: " + getStatus() +
                "\nISBN: " + isbn +
                "\nAuthor: " + author +
                "\nGenre: " + genre;
    }
}
