/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DB.DBConnector;
import DB.DataBaseConnector;
import Data.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author sinanjasar
 */
public class UserMapper {
/*
    private static DataBaseConnector dbc = new DataBaseConnector();

    public static void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public static User getUser(String username) {
        User user = null;
        try {
            dbc.open();
            String sql = "SELECT * FROM user WHERE username = '?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username_ = resultSet.getString("username");
                String password = resultSet.getString("password");
                float balance = resultSet.getFloat("balance");

                //user = new User(username_, password, balance);
            }
            dbc.close();
        } catch (Exception e) {
        }
        return user;
    }

    public static void insertUser(String username, String password, float balance) {
        try {
            dbc.open();

            String sql = "insert into user (username, password, balance) values (?,?,?,?)";

            PreparedStatement preparedStatement = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setDouble(3, balance);

            preparedStatement.executeUpdate();

            dbc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
