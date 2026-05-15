import com.library.domain.Item;
import com.library.domain.Magazine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MagazineTest {

    @Test
    @DisplayName("toCSV1: Magazine(\"Science Weekly\") -> magazine,Science Weekly,IN_STORE,45,Nature")
    public void toCSV1() {
        Magazine magazine = new Magazine(
                "Science Weekly",
                Item.Status.IN_STORE,
                45,
                "Nature"
        );

        String expected = "magazine,Science Weekly,IN_STORE,45,Nature\n";
        String actual = magazine.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}
