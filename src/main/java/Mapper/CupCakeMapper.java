/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DB.DataBaseConnector;
import Data.Topping;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author sinanjasar
 */
public class CupCakeMapper {

    private static DataBaseConnector dbc = new DataBaseConnector();

    public static void setDataSource(DataSource ds) {
        dbc.setDataSource(ds);
    }

    public static ArrayList<Topping> toppings() throws Exception {

        ArrayList<Topping> toppingList = new ArrayList();

        try {
            dbc.open();
            String sql = "SELECT flavour, price FROM topping;";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String flavour = rs.getString("flavour");
                float price = rs.getFloat("price");

                toppingList.add(new Topping(price, flavour));
            }
            dbc.close();
        } catch (Exception e) {

        }
        return toppingList;
    }
    public static ArrayList<Topping> bottoms() throws Exception {

        ArrayList<Topping> toppingList = new ArrayList();

        try {
            dbc.open();
            String sql = "SELECT flavour, price FROM bottoms;";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String flavour = rs.getString("flavour");
                float price = rs.getFloat("price");

                toppingList.add(new Topping(price, flavour));
            }
            dbc.close();
        } catch (Exception e) {

        }
        return toppingList;
    }
}
