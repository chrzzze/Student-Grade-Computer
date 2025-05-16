import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradeManager {
    private String filePath;

    public GradeManager(String filePath) {
        this.filePath = filePath;
    }

    public void enterGrade(Scanner sc, SubjectManager sm) {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> storedGrades = new ArrayList<>();
    ArrayList<String> studentFile = DataManagement.read(Data.students.getPath());
    for (int i = 0; i < studentFile.size(); i++) {
        if (studentFile.get(i).contains(" {")) {
            String[] str = studentFile.get(i).replace(" {", "").split(", ");
            String lastName = str[0];
            String firstName = str[1];

            Student student = new Student(lastName, firstName);
            i++;

            System.out.println(student.getName() + ": ");
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
                    System.out.println(" FAILED");
                } else {
                    System.out.println(" PASSED");
                }
                i++;
                f++;


            }
            students.add(student);

        }
    }

        System.out.print("Enter student name: (Lastname, Firstname");
        String studentName = sc.nextLine();
        Student chosenStudent = null;

        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(studentName, students.get(i).getName())) {
                chosenStudent = students.get(i);
            }
        }

        if (chosenStudent == null) {
            System.out.println("Couldn't find 'em. sorry.");
        }

        List<String> subjects = sm.getSubjects();
        if (subjects.isEmpty()) {
            System.out.println("No subjects found. Ask an admin for assistance.");
            return;
        }

        double total = 0;
        int count = 0;

        for (String subj : subjects) {
            double grade = 0.00;
            while (true) {
                System.out.print("Enter grade for " + subj + ": ");
                grade = sc.nextDouble();
                sc.nextLine();
                if (grade > 100.00 || grade < 0.00) {
                    System.out.println("Invalid grade. Please enter a number from 0 - 100.");
                } else {
                    break;
                }
            }



            String status = grade >= 75 ? "Pass" : "Fail";
            total += grade;
            count++;


            storedGrades.add(subj + "; " + grade);
            System.out.println(storedGrades);



//            // WILL PRINT IF THE STUDENT PASSED OR FAILED THE SUBJECT
//            System.out.println(subj + ": " + grade + " | " + status);
//            System.out.println(" ");
//
//            // WILL SAVE THE FILE
//            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
//                pw.println(studentName + ", " + subj + ", " + grade + ", " + status);
//            } catch (IOException e) {
//                System.out.println("Error saving grade.");
//            }
        }



        double gwa = total / count;
        System.out.printf("GWA for %s: %.2f (%s)%n", studentName, gwa, gwa >= 75 ? "Pass" : "Fail");
    }
}