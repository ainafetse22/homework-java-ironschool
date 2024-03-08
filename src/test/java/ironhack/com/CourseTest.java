package ironhack.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        teacher = new Teacher();
        course = new Course("Math", 100.0, teacher);
    }

    @Test
    public void testValidateCourseInfo() {
        assertTrue(course.validateCourseInfo());
    }

    @Test
    public void testValidateCourseInfoWithoutName() {
        course.setName(null);
        assertFalse(course.validateCourseInfo());
    }

    @Test
    public void testValidateCourseInfoWithoutPrice() {
        course.setPrice(0);
        assertFalse(course.validateCourseInfo());
    }

    @Test
    public void testValidateCourseInfoWithoutTeacher() {
        course.setTeacher(null);
        assertFalse(course.validateCourseInfo());
    }
}
