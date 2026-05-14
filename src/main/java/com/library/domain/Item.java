package com.library.domain;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Item {

    private int id;
    private String title;
    private String status;

    public abstract String getDetails();

}
