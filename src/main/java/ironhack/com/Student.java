package ironhack.com;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
public class Student extends Person {
    private String address;
    private String email;
    private List<Course> courseList;

    public Student(String name, String address, String email) throws IllegalArgumentException {
        super(name);
        validateInput(name, address, email);
        this.address = address;
        this.email = email;
    }

    public Student(String name, String address, String email, List<Course> courseList) throws IllegalArgumentException {
        super(name);
        validateInput(name, address, email);
        if (courseList == null || courseList.isEmpty()) {
            throw new IllegalArgumentException("Course list cannot be null or empty");
        }
        this.address = address;
        this.email = email;
        this.courseList = courseList;
    }

    private void validateInput(String name, String address, String email) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (email == null || email.isEmpty() || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public void printInfo() {
        System.out.println("Id: " + getId()
                + ", Name: " + getName()
                + ", Address: " + getAddress()
                + ", Email: " + getEmail()
                + ", Courses: " + (getCourseList() != null ? getCourseList().toString() : "N/A"));
    }
}