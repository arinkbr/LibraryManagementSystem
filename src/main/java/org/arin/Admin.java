package org.arin;

public class Admin extends User {

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
