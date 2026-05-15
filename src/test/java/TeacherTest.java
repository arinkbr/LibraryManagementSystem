import com.library.domain.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    @DisplayName("toCSV1: Teacher(\"Michael\") -> teacher,Michael,0001")
    public void toCSV1() {
        Teacher teacher = new Teacher("Michael");
        String expected = "teacher,Michael,0001\n";
        String actual = teacher.toCSV();

        Assertions.assertEquals(expected, actual);
    }
}