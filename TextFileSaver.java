import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileSaver {
// gawa ni rusty
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the subject of the text file: ");
        String subject = scanner.nextLine();

        System.out.print("Enter the content you want to save: ");
        String content = scanner.nextLine();

        String filename = subject.replaceAll("\\s+", "_") + ".txt"; 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Text successfully saved to: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
