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
    public static User getUser(String username) {

        String username_ = "";
        String password = "";
        float balance = 0;

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
            }
        } catch (Exception e) {
        }
        return new User(username_, password, balance);
    }
    public static void insertUser(String name, String password, float balance) {
        try {
            DBConnector conn = new DBConnector();
            Statement statement = conn.getConnection().createStatement();
            String query
                    = "INSERT INTO user(username, password, balance) "
                    + "VALUES ('"+ name + "', '" + password + "', " + balance + ");";
            statement.executeUpdate(query);

        } catch (Exception e) {
        }
    }
}
