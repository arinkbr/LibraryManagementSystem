package com.library.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class DVD extends Item {

    private String director;
    private int duration;

    public DVD(String title, Status status,
               String director, int duration) {

        super(title, status);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toCSV() {
        return "dvd," +
                getTitle() + "," +
                getStatus() + "," +
                director + "," +
                duration + "\n";
    }
}
