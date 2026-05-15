import com.library.domain.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    @DisplayName("toCSV1: Admin(\"Bill\") -> admin,Bill,0001")
    public void toCSV1() {
        Admin admin = new Admin("Bill");
        String expected = "admin,Bill,0001\n";
        String actual = admin.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}
