import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       
        File subjectstxt = new File("data//subjects.txt");
//        DataManagement.write(subjectstxt.getPath(),  "test test ahhhhhh"); //testing lang toh, the file is DataManagement.java

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        Account currentUser = AdminLogin.authenticate(usernameInput, passwordInput);
        if (currentUser == null) {
            System.out.println("Failed to log in.");
        } else {
            System.out.println("Logged in as: " + currentUser.username);
        }
       
       
       
        // try {
        //     File subjectstxt = new File("data//subjects.txt");
        //     FileReader reader = new FileReader(subjectstxt.getPath());
        //     BufferedReader bufferedReader = new BufferedReader(reader);

        //     String line;
        //     while ((line = bufferedReader.readLine()) != null) {
        //         System.out.println(line);
        //     }
        //     reader.close();
        // } catch (IOException e) {
        //     System.out.println("you did it wrong");
        // }
    }
}