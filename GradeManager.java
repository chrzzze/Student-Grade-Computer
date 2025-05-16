import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GradeManager {
    private String filePath;

    public GradeManager(String filePath) {
        this.filePath = filePath;
    }

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> studentFile = DataManagement.read(Data.students.getPath()); //student file

    public void initGrades(boolean displayGrades) {
        students.clear(); //refresh
        for (int i = 0; i < studentFile.size(); i++) { //for every line...
            if (studentFile.get(i).contains(" {")) { //find the header
                String[] str = studentFile.get(i).replace(" {", "").split(", "); // get the first and last names
                String lastName = str[0];
                String firstName = str[1];

                Student student = new Student(lastName, firstName); //and turn em into a student
                i++; //next line
                if (displayGrades) {
                    System.out.println();
                }
                System.out.println(student.getName());
                int f = 0;
                while (true) {
                    if (studentFile.get(i).contains("}")) { //check if datablock has ended
                        break;
                    }
                    String[] data = studentFile.get(i).split("; "); //divide the line by the ;
                    student.subjects.add(new Subject(data[0])); //first one's always the subject name
                    student.subjects.get(f).grade = Double.parseDouble(data[1]); //and the second's the grade
                    if (displayGrades) { //if displaying grades
                        System.out.print(student.subjects.get(f).getName() + ": "); //print em out like this
                        System.out.print(student.subjects.get(f).grade);
                        if (student.subjects.get(f).grade < 75) { //output if failed or passed also
                            System.out.println(" (FAILED)");
                        } else {
                            System.out.println(" (PASSED)");
                        }
                    }
                    i++; //next line in general
                    f++; //next line in the datablock



                }
                students.add(student); //add the student to the list

            }
        }
    }
    public void enterGrade(Scanner sc, SubjectManager sm) {

        initGrades(false);
        ArrayList<String> storedGrades = new ArrayList<>();

        Student chosenStudent = null;

        System.out.print("Enter student name (Lastname, Firstname): ");
        String studentName = sc.nextLine();


        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(studentName, students.get(i).getName())) {
                chosenStudent = students.get(i);
            }
        }

        if (chosenStudent == null) {
            System.out.println("Couldn't find the student.");
        }

        List<String> subjects = sm.getSubjects();
        if (subjects.isEmpty()) {
            System.out.println("No subjects found. Ask an admin for assistance.");
            return;
        }

        double total = 0;
        int count = 0;

        for (String subj : subjects) {
            double grade;
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
            total += grade;
            count++;

            storedGrades.add(subj + "; " + grade);

        }
        for (int i = 0; i < studentFile.size(); i++) {
            if (studentFile.get(i).contains(chosenStudent.getName())) {
                boolean terminated = false;
                i++;
                i++;
                while (!terminated) {
                    if (studentFile.get(i).contains("}")) {
                       i--;
                       terminated = true;
                    }
                    studentFile.remove(i);
                }
                for (int j = 0; j < storedGrades.size(); j++) {
                    studentFile.add(i, storedGrades.get(j));
                    i++;
                }

            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Data.students)))
        {
            for (String str : studentFile) {
                writer.write(str);
                writer.newLine();
            }
            System.out.println("Yaaay written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        double gwa = total / count;
        System.out.printf("GWA for %s: %.2f (%s)%n", studentName, gwa, gwa >= 75 ? "Pass" : "Fail");
    }
}