import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeViewer {
    private static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        view();
    }
    static void view () {
        ArrayList<String> studentFile = DataManagement.read(Data.students.getPath());
        for (int i = 0; i < studentFile.size(); i++) {
            if (studentFile.get(i).contains(" {")) {
                String[] str = studentFile.get(i).replace(" {", "").split(", ");
                String lastName = str[0];
                String firstName = str[1];

                Student student = new Student(lastName, firstName);
                System.out.println(student.getName());
                i++;

                int f = 0;
                while (true) {
                    if (studentFile.get(i).contains("}")) {
                        break;
                    }
                    String[] data = studentFile.get(i).split(", ");
                    student.subjects.add(new Subject(data[0]));
                    student.subjects.get(f).grade = Double.parseDouble(data[1]);
                    System.out.print(student.subjects.get(f).getName() + ": ");
                    System.out.print(student.subjects.get(f).grade);
                    if (student.subjects.get(f).grade < 75) {
                        System.out.print(" FAILED");
                    } else {
                        System.out.print(" PASSED");
                    }
                    i++;
                    f++;


                }
                students.add(student);

            }
        }
        System.out.println(students);

    }
}

