package org.arin;

import lombok.*;

@Getter
@Setter
@ToString
public class Admin extends User implements Reportable{

    public Admin(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {

        return false;
    }

    /**
     * Generates a library report.
     */
    public void generateReport() {
        System.out.println("Generating library report...");
    }
}
