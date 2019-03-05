/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import DB.DBConnector;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Obaydah Mohamad
 */
public class OrdersDAO {
    public static ArrayList<Order> getOrders(String username) {
        ArrayList<Order> orders = new ArrayList<Order>();
        int orderId = 0;
        String username_ = "";
        String datePlaced = "";

        try {
            DBConnector con = new DBConnector();
            Statement statement = con.getConnection().createStatement();
            String query
                    = "SELECT * "
                    + "FROM invoice "
                    + "WHERE username = '" + username + "' ORDER BY id DESC;";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                orderId = rs.getInt("id");
                username_ = rs.getString("username");
                datePlaced = rs.getString("dateplaced");
                orders.add(new Order(orderId, username_, datePlaced));
            }
        } catch (Exception e) {
        }
        System.out.println(orders.size());
        return orders;
    }
}
