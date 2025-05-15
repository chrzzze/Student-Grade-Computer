import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin {
    // Admin credentials
    static Account authenticate (String username,String password) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        String accountlist = DataManagement.read(Config.accounts.getPath());
        Account match = null;


        return match;
    }
//    private static final String ADMIN_USERNAME = "teacher";
//    private static final String ADMIN_PASSWORD = "STICA";
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter username: ");
//        String inputUsername = scanner.nextLine();
//
//        System.out.print("Enter password: ");
//        String inputPassword = scanner.nextLine();
//
//        if (authenticate(inputUsername, inputPassword)) {
//            System.out.println("Login successful. Welcome, Admin!");
//            // Admin functionality
//        } else {
//            System.out.println("Login failed. Incorrect username or password.");
//        }
//
//        scanner.close();
//    }

//    private static boolean authenticate(String username, String password) {
//        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
//    }
}