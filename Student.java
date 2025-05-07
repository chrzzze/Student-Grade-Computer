import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    String name, subject;
    Double grade;

    public Student(String name, String subject, Double grade) {
        try {
            File subjectstxt = new File("data//subjects.txt");
            FileReader reader = new FileReader(subjectstxt.getPath());
            BufferedReader bufferedReader = new BufferedReader(reader);

            String subjects = bufferedReader.readLine();
            System.out.println("Subjects: " + subjects);

            // Split the string using comma as delimiter
            String[] subs = subjects.split(", ");

            // Display each element of the array
            for (int i = 0; i < subs.length; i++) {
                System.out.println("Subject " + (i+1) + ": " + subs[i]);

            }

            for (int i = 0; i < subs.length) {
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("you did it wrong");
        }


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


