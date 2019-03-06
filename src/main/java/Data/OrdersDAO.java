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
        return orders;
    }
    
    public static Order getOrder(int id) {
        Order order = null;
        int orderId = 0;
        String username_ = "";
        String datePlaced = "";

        try {
            DBConnector con = new DBConnector();
            Statement statement = con.getConnection().createStatement();
            String query
                    = "SELECT * "
                    + "FROM invoice "
                    + "WHERE id = " + id + ";";
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                orderId = rs.getInt("id");
                username_ = rs.getString("username");
                datePlaced = rs.getString("dateplaced");
                order = new Order(orderId, username_, datePlaced);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(orderId);
        System.out.println(username_);
        System.out.println(datePlaced);

        return order;
    }
    
    public static ArrayList<LineItems> getOrderDetails(int id){
        ArrayList<LineItems> lineitems = new ArrayList<LineItems>();
        Topping top = null;
        Bottom bot = null;
        float totalPrice = 0;
        int qty = 0;
       
        try {
            DBConnector con = new DBConnector();
            Statement statement = con.getConnection().createStatement();
            String query
                    = "SELECT topping_flavour, bottom_flavour, qty, price "
                    + "FROM lineitem "
                    + "WHERE invoice_id = " + id + ";";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                qty = rs.getInt("qty");
                top = CupCakeDAO.getTopping(rs.getString("topping_flavour"));
                bot = CupCakeDAO.getBottom(rs.getString("bottom_flavour"));
                lineitems.add(new LineItems(new CupCake(top, bot), qty));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }       
        return lineitems;
    }
}
