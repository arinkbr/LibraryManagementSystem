package com.library.domain;

import com.library.util.Validation;
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

        if (!Validation.isValidISBN(isbn)) {
            throw new RuntimeException("Invalid ISBN");
        }
    }

    @Override
    public String toCSV() {
        return "book," +
                getTitle() + "," +
                getStatus() + "," +
                isbn + "," +
                author + "," +
                genre + "\n";
    }
}
