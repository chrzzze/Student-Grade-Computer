import java.util.ArrayList;
import java.util.Objects;

public class AdminLogin {
    // Admin credentials
    static Account authenticate (String username,String password) {
        ArrayList<Account> accounts = new ArrayList<>(); // all the accounts

        ArrayList<String> accountlist = DataManagement.read(Data.accounts.getPath()); //the raw text file, in lines
        for (int i = 0; i < accountlist.size(); i = i+4) {
            accounts.add(new Account(accountlist.get(i), accountlist.get(i+1), accountlist.get(i+2))); //make a new account for every group of 3 lines with the type, username, and password respectfully
        }
        Account loggedOnUser = null; //if it's null there's no match
        for (Account account : accounts) {
            if (Objects.equals(username, account.username)) {
                if (Objects.equals(password, account.password)) {
                    loggedOnUser = account;
                    break;
                }
            }
        }

        return loggedOnUser;

    }
}
