public class Student {
    String name, subject;
    Double grade;

    public Student(String name, String subject, Double grade) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
    }

    void info() {
        System.out.println(name);
        System.out.println(subject);
        System.out.println(grade);
    }
}


