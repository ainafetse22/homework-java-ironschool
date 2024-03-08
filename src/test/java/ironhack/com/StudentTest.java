package ironhack.com;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testValidStudent() {
        List<Course> courses = Arrays.asList(new Course("Math"), new Course("English"));
        assertDoesNotThrow(() -> new Student("John Doe", "123 Main St", "john.doe@example.com", courses));
    }

    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "123 Main St", "john.doe@example.com"));
    }

    @Test
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("", "123 Main St", "john.doe@example.com"));
    }

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John Doe", null, "john.doe@example.com"));
    }

    @Test
    public void testEmptyAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John Doe", "", "john.doe@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John Doe", "123 Main St", "john.doe"));
    }

    @Test
    public void testNullCourseList() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John Doe", "123 Main St", "john.doe@example.com", null));
    }

    @Test
    public void testEmptyCourseList() {
        assertThrows(IllegalArgumentException.class, () -> new Student("John Doe", "123 Main St", "john.doe@example.com", Arrays.asList()));
    }
}
