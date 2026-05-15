import com.library.util.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    @DisplayName("isValidISBN1: Returns true for valid 13 digit ISBN")
    public void isValidISBN1() {
        String isbn = "9780439023481";
        boolean actual = Validation.isValidISBN(isbn);

        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("isValidISBN2: Returns false for ISBN containing letters")
    public void isValidISBN2() {
        String isbn = "97804390ABCD1";
        boolean actual = Validation.isValidISBN(isbn);

        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("isValidISBN3: Returns false when ISBN is null")
    public void isValidISBN3() {
        String isbn = null;
        boolean actual = Validation.isValidISBN(isbn);

        Assertions.assertFalse(actual);
    }
}
