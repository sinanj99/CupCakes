/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DB.DataBaseConnector;
import Data.LineItems;
import Data.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author sinanjasar
 */
public class ShoppingCartMapper {

    private static DataBaseConnector dbc = new DataBaseConnector();

    public static void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public void insertOrder(User user, List<LineItems> lineitems) {
        try {
            dbc.open();
            String sql = "INSERT INTO invoice(username) VALUES(?);";
            PreparedStatement ps = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());

            ps.executeUpdate();

            sql = "INSERT INTO lineitems VALUES(?,?,?,?);";
            ps = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (LineItems l : lineitems) {
                String topping = l.getCup().getCupCakeTopping().getFlavour();
                String bottom = l.getCup().getCupCakeBottom().getFlavour();
                int qty = l.getQuantity();
                float price = l.getCup().getTotalPrice() * l.getQuantity();
                ps.setString(1, topping);
                ps.setString(2, bottom);
                ps.setInt(3, qty);
                ps.setFloat(4, price);

                ps.executeUpdate();
            }

            dbc.close();

        } catch (Exception ex) {

        }
    }
}
