import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager("data/accounts.txt");
        SubjectManager subjectManager = new SubjectManager("data/subjects.txt");
        GradeManager gradeManager = new GradeManager("data/grades.txt");

        Scanner scanner = new Scanner(System.in);

        // LOGIN MENU
        System.out.println("\n===== Login =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userManager.authenticate(username, password);

        if (user == null) {
            System.out.println("Login failed. Exiting.");
            return;
        }

        System.out.println("\nWelcome, " + username + "!");

        if (user.getRole().equals("admin")) {
            adminMenu(userManager, subjectManager, scanner);
        } else if (user.getRole().equals("teacher")) {
            teacherMenu(subjectManager, gradeManager, scanner);
        }
    }

    static void adminMenu(UserManager userManager, SubjectManager subjectManager, Scanner scanner) {
        while (true) {

            // 1ADMIN MENU
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Subject");
            System.out.println("3. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> userManager.addUser(scanner);
                case 2 -> subjectManager.addSubject(scanner);
                case 3 -> {
                    return;
                }
            }
        }
    }

    static void teacherMenu(SubjectManager subjectManager, GradeManager gradeManager, Scanner scanner) {
        while (true) {

            // TEACHER MENU
            System.out.println("\n=== Teacher Menu ===");
            System.out.println("1. Enter Grade");
            System.out.println("2. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> gradeManager.enterGrade(scanner, subjectManager);
                case 2 -> {
                    return;
                }
            }
        }
    }
}