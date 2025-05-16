import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class GradeManager {
    private String filePath;

    public GradeManager(String filePath) {
        this.filePath = filePath;
    }

    public void enterGrade(Scanner sc, SubjectManager sm) {
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

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

            // WILL PRINT IF THE STUDENT PASSED OR FAILED THE SUBJECT
            System.out.println(subj + ": " + grade + " | " + status);
            System.out.println(" ");

            // WILL SAVE THE FILE
            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
                pw.println(studentName + ", " + subj + ", " + grade + ", " + status);
            } catch (IOException e) {
                System.out.println("Error saving grade.");
            }
        }

        double gwa = total / count;
        System.out.printf("GWA for %s: %.2f (%s)%n", studentName, gwa, gwa >= 75 ? "Pass" : "Fail");
    }
}