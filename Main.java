import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean loggedIn = false;
        Account currentUser = null;
        while (loggedIn == false){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String usernameInput = scanner.nextLine();
            System.out.print("Enter password: ");
            String passwordInput = scanner.nextLine();

            currentUser = AdminLogin.authenticate(usernameInput, passwordInput);
            if (currentUser == null) {
                System.out.println("Failed to log in.");
            } else {
                System.out.println("Logged in as: " + currentUser.username);
                loggedIn = true;
            } //log in
        }

        if (currentUser.type.equals(Account.AccountType.ADMIN)) { //admin functions
            System.out.println("You're an admin babey.");


        } else { //teacher functions
            System.out.println("Teacher mode.");
        }

       

    }
}