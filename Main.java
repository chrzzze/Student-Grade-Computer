import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
            reader.close();
        } catch (IOException e) {
            System.out.println("you did it wrong");
        }
    }
}
