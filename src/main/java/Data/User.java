/*
 This class is used to create a user with the given fields. 
 */
package Data;

/**
 *
 * @author sinanjasar
 */
public class User {
    private String username;
    private String password;
    private float balance;
    private Enum isAdmin;

    public User(String username, String password, float balance, Enum isAdmin) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float getBalance() {
        return balance;
    }

    public Enum getIsAdmin() {
        return isAdmin;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
}
