import java.io.*;
import java.util.*;

public class SubjectManager {
    private String filePath;
    private List<String> subjects = new ArrayList<>();

    public SubjectManager(String filePath) {
        this.filePath = filePath;
        loadSubjects();
    }

    private void loadSubjects() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                subjects.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Subject file not found. Creating new...");
        }
    }

    // ADMIN - "ADD SUBJECT" CHOICE
    public void addSubject(Scanner sc) {
        System.out.print("Enter subject name: ");
        String subject = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
            pw.println(subject);
            subjects.add(subject);
            System.out.println("Subject added.");
        } catch (IOException e) {
            System.out.println("Error writing subject.");
        }
    }

    public List<String> getSubjects() {
        return subjects;
    }
}