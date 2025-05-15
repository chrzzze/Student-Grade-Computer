import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

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
       

    }
}