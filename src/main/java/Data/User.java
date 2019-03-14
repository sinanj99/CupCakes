/*
 This class is used to create a user with the given fields. 
 */
package Data;

/**
 * Mirrors the user-table in the database, and is primarily instantiated in the
 * user mappers where a given user is returned and forwarded to the logic-layer
 * where a user is validated. Is also instantiated in presentation-layer when it is checked
 * if there is already a user in the session.
 * @author sinanjasar
 */

public class User {
    private String username;
    private String password;
    private float balance;
    private int isAdmin;

    public User(String username, String password, float balance, int isAdmin) {
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

    public int getIsAdmin() {
        return isAdmin;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
}
