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
    private Enum isCustomer;

    public User(String username, String password, float balance, Enum isCustomer) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.isCustomer = isCustomer;
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

    public Enum getIsCustomer() {
        return isCustomer;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
}
