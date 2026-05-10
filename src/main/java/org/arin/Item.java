package org.arin;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Item {

    private int id;
    private String title;
    private String status;


}
