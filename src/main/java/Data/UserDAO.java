/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                    + "FROM recipe "
                    + "WHERE username = '" + username + "';";
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                username_ = rs.getString("ID");
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
                    = "INSERT INTO user(name, password, balance) "
                    + "VALUES ('"+ name + "', '" + password + "', " + balance + ");";
            statement.executeUpdate(query);

        } catch (Exception e) {
        }
    }
}
