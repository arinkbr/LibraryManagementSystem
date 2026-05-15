import com.library.domain.DVD;
import com.library.domain.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class dvdTest {

    @Test
    @DisplayName("toCSV1: DVD(\"Interstellar\") -> dvd,Interstellar,IN_STORE,Christopher Nolan,169")
    public void toCSV1() {
        DVD dvd = new DVD(
                "Interstellar",
                Item.Status.IN_STORE,
                "Christopher Nolan",
                169
        );

        String expected = "dvd,Interstellar,IN_STORE,Christopher Nolan,169\n";
        String actual = dvd.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}