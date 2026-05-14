package org.arin;

import lombok.*;

@Getter
@Setter
@ToString
public class Book extends Item {

    private String isbn;
    private String author;
    private String genre;

    public Book(int id, String title, String status, String isbn, String author, String genre) {
        super(id, title, status);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getDetails() {
        return "Book ID: " + getId() +
                "\nTitle: " + getTitle() +
                "\nStatus: " + getStatus() +
                "\nISBN: " + isbn +
                "\nAuthor: " + author +
                "\nGenre: " + genre;
    }
}
