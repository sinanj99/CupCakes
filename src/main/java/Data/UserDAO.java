/*
 This class accesses the database via statements and queries. 
 getUser() selects all data on user with the passed username.
 insertUser() inserts new user data to the user table.
 */
package Data;

import DB.DBConnector;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sinanjasar
 */
public class UserDAO {
    /**
     * Selects and returns a specific user-object from the 'user'-table in the database.
     * @param username is used in the WHERE clause to find a specified user
     * @return a specified user defined by the username
     */
    public static User getUser(String username) {

        String username_ = "";
        String password = "";
        float balance = 0;
        int isAdmin = 0;

        try {
            DBConnector con = new DBConnector();
            Statement statement = con.getConnection().createStatement();
            String query
                    = "SELECT * "
                    + "FROM user "
                    + "WHERE username = '" + username + "';";
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                username_ = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getFloat("balance");
                isAdmin = rs.getInt("isadmin");
            }
            
        } catch (Exception e) {
        }
        return new User(username_, password, balance, isAdmin);
    }
    /**
     * Inserts a new user into user-tabel with the specified data.
     * @param name name of the user to be inserted
     * @param password password of the user to be inserted 
     * @param balance balance of the user to be inserted
     */
    public static void insertUser(String name, String password, float balance) {
        try {
            DBConnector conn = new DBConnector();
            Statement statement = conn.getConnection().createStatement();
            String query
                    = "INSERT INTO user(username, password, balance, isAdmin) "
                    + "VALUES ('"+ name + "', '" + password + "', " + balance + ", 0);";
            statement.executeUpdate(query);

        } catch (Exception e) {
        }
    }
    /**
     * Updates balance of a user with the specified name to the new, specified balance.
     * @param username username of the user whose balance needs update
     * @param balance new balance of the user 
     */
    public static void setBalance(String username, float balance)
    {
        try {
            DBConnector conn = new DBConnector();
            Statement statement = conn.getConnection().createStatement();
            String query
                    = "UPDATE user SET balance = " 
                    + balance + " WHERE username = '" + username + "';" ;
            statement.executeUpdate(query);

        } catch (Exception e) {
        }
    }
}
