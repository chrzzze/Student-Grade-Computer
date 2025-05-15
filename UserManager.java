import java.io.*;
import java.util.*;

public class UserManager {
    private String filePath;
    private Map<String, User> users = new HashMap<>();

    public UserManager(String filePath) {
        this.filePath = filePath;
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    users.put(parts[0], new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("User file not found. Creating new...");
        }
    }

    public User authenticate(String username, String password) {
        User u = users.get(username);
        return (u != null && u.checkPassword(password)) ? u : null;
    }

    // 1ADMIN - "ADD USER" CHOICE
    public void addUser(Scanner sc) {
        System.out.print("Enter new username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();
        System.out.print("Enter role (admin/teacher): ");
        String r = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
            pw.println(u + "," + p + "," + r);
            users.put(u, new User(u, p, r));
            System.out.println("User added.");
        } catch (IOException e) {
            System.out.println("Error writing user.");
        }
    }
}