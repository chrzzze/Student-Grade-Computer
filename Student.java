import java.util.ArrayList;

public class Student {
    private String lastName;
    private String firstName;

    ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String lastName() { return lastName; }
    public String firstName() { return firstName; }
    public String getName() {return lastName + ", " + firstName; }

}