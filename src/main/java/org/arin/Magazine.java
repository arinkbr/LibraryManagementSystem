package org.arin;

public class Magazine extends Item {

    private int issueNumber;
    private String publisher;

    public Magazine(int id, String title, String status,
                    int issueNumber, String publisher) {

        super(id, title, status);

        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
}
