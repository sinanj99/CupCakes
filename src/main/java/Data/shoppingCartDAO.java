/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DB.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper Jeppesen & sinanjasar
 */
public class shoppingCartDAO {

    public static void insertOrder(User user, List<LineItems> lineitems) {
        try {
            int id = 0;
            String name = "";
            DBConnector con = new DBConnector();
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs1 = null;

            rs1 = stmt.executeQuery("INSERT INTO invoice(username) VALUES (" + user.getUsername() + ");");

            while (rs1.next()) {
                id = rs1.getInt("id");
                name = rs1.getString("username");
            }

            ResultSet rs2 = null;
            for (LineItems l : lineitems) {
                String topping = l.getCup().getCupCakeTopping().getFlavour();
                String bottom = l.getCup().getCupCakeBottom().getFlavour();
                int qty = l.getQuantity();
                float price = l.getCup().getTotalPrice() * l.getQuantity();
                rs2 = stmt.executeQuery("INSERT INTO lineitems VALUES (" + id + "," + topping
                        + "," + bottom + "," + qty + "," + price + ");");
            }

        } catch (Exception ex) {
           
        }
    }
}
