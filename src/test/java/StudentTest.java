import com.library.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    @DisplayName("toCSV1: Student(\"Alex\") -> student,Alex,0001")
    public void toCSV1() {
        Student student = new Student("Alex");
        String expected = "student,Alex,0001\n";
        String actual = student.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}
