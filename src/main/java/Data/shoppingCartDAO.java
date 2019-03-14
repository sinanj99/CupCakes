/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DB.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper Jeppesen & sinanjasar
 */
public class shoppingCartDAO {

    public static void insertOrder(User user, List<LineItems> lineitems) {

        Connection connection = null;

        try {

            String name = "";
            DBConnector con = new DBConnector();
            connection = con.getConnection();
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

            stmt.executeUpdate("INSERT INTO invoice(username, dateplaced) VALUES ('" + user.getUsername() + "', '" + timeStamp + "');");

            for (LineItems l : lineitems) {
                String topping = l.getCup().getCupCakeTopping().getFlavour();
                String bottom = l.getCup().getCupCakeBottom().getFlavour();
                int qty = l.getQuantity();
                float price = l.getCup().getTotalPrice() * l.getQuantity();
                stmt.executeUpdate("INSERT INTO lineitem VALUES ((SELECT id FROM invoice WHERE username = '" + user.getUsername()
                        + "' ORDER BY id DESC LIMIT 1), '" + topping + "', '" + bottom + "', " + qty + " , " + price + ");");
            }
            connection.commit();
        } catch (Exception ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    public static int getOrder(User user) {
        int id = 0;
        try {
            DBConnector con = new DBConnector();
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT id FROM invoice WHERE username = '" + user.getUsername()
                    + "' ORDER BY id DESC LIMIT 1;");
            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

}
