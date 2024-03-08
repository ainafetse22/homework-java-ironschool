package ironhack.com;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String Id;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public void setId(){
        setId(Utils.generateSerialId());
    }
    public Course(String name) {
        setId();
        setName(name);
    }

    public Course(String name, double price){
        setId();
        setName(name);
        setPrice(price);
    }
    public Course(String name, double price,Teacher teacher){
        setId();
        setName(name);
        setPrice(price);
        setTeacher(teacher);
    }
    public void assign(Teacher teacher) {
        setTeacher(teacher);
    }

    public boolean validateCourseInfo() {
        if (this.name == null || this.name.isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return false;
        }
        if (this.price <= 0) {
            System.out.println("Course price must be greater than zero.");
            return false;
        }
        if (this.teacher == null) {
            System.out.println("Course must have a teacher assigned.");
            return false;
        }
        return true;
    }
}
