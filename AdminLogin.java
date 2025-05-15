import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AdminLogin {
    // Admin credentials
    static Account authenticate (String username,String password) {
        ArrayList<Account> accounts = new ArrayList<Account>(); // all the accounts

        ArrayList<String> accountlist = DataManagement.read(Config.accounts.getPath()); //the raw text file, in lines
        for (int i = 0; i < accountlist.size(); i = i+3) {
            accounts.add(new Account(accountlist.get(i), accountlist.get(i+1), accountlist.get(i+2))); //make a new account for every group of 3 lines with the type, username, and password respectfully
        }
        Account loggedOnUser = null; //if its null there's no match
        for (Account account : accounts) {
            if (Objects.equals(username, account.username)) {
                if (Objects.equals(password, account.password)) {
                    loggedOnUser = account;
                    System.out.println(loggedOnUser.username);
                    break;
                }
            }
        }

        return loggedOnUser;
    }
}