package com.library.domain;

import lombok.*;

@Getter
public class Magazine extends Item {
    private int issueNumber;
    private String publisher;

    public Magazine(String title, Status status,
                    int issueNumber, String publisher) {

        super(title, status);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    @Override
    public String toCSV() {
        return "Magazine ID: " + getId() +
                "\nTitle: " + getTitle() +
                "\nStatus: " + getStatus() +
                "\nIssue Number: " + issueNumber +
                "\nPublisher: " + publisher;
    }
}
