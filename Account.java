public class Account {
    enum AccountType {ADMIN, TEACHER};
    String username, password;
    AccountType type;

    public Account(String type, String username, String password) {
        this.type = AccountType.valueOf(type);
        this.username = username;
        this.password = password;
    }
}
