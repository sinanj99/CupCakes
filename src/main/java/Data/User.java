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

    public User(String username, String password, float balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
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
    
}
