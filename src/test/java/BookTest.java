import com.library.domain.Book;
import com.library.domain.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    @DisplayName("toCSV1: Book(\"Harry Potter\") -> book,Harry Potter,IN_STORE,1234567890123,J.K Rowling,Fantasy")
    public void toCSV1() {
        Book book = new Book(
                "Harry Potter",
                Item.Status.IN_STORE,
                "1234567890123",
                "J.K Rowling",
                "Fantasy"
        );

        String expected = "book,Harry Potter,IN_STORE,1234567890123,J.K Rowling,Fantasy\n";
        String actual = book.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}