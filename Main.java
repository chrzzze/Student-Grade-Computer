import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File subjectstxt = new File("data//subjects.txt");
            FileReader reader = new FileReader(subjectstxt.getPath());
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("you did it wrong");
        }
    }
}
