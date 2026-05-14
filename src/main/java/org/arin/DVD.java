package org.arin;

public class DVD extends Item {

    private String director;
    private int duration;

    public DVD(int id, String title, String status,
               String director, int duration) {

        super(id, title, status);

        this.director = director;
        this.duration = duration;
    }

    @Override
    public String getDetails() {
        return "DVD ID: " + getId() +
                "\nTitle: " + getTitle() +
                "\nStatus: " + getStatus() +
                "\nDirector: " + director +
                "\nDuration: " + duration + " minutes";
    }
}
