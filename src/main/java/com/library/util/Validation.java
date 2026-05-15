package com.library.util;

public class Validation {
    /**
     * Checks if an ISBN is valid.
     * A valid ISBN must contain exactly 13 digits.
     * @param isbn ISBN to validate
     * @return true if the ISBN is valid, false otherwise
     */
    public static boolean isValidISBN(String isbn) {
        if (isbn == null) {
            return false;
        }

        return isbn.matches("\\d{13}");
    }
}
