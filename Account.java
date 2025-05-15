public class Account {
    enum AccountType {ADMIN, TEACHER};
    String username, password;
    AccountType type;

    public Account(String username, String password, AccountType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }
}
