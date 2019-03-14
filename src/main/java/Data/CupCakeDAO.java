/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import DB.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Younes
 */
public class CupCakeDAO {
    
    /**
     * Selects and returns all topping-objects from the 'topping'-table in the database.
     * @return ArrayList of topping-objects from database
     * @throws Exception if a connection or SQL error occurs
     */
    public static ArrayList<Topping> toppings() throws Exception{
        
        ArrayList<Topping> toppingList = new ArrayList();
        Connection connection = null;
        
        try{
        int id = 0;
        String flavour = "";
        float price = 0;
        
        
        DBConnector con = new DBConnector();
        connection = con.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT flavour, price FROM topping;");
        
        while(rs.next()){
            flavour = rs.getString("flavour");
            price = rs.getFloat("price"); 
            
            toppingList.add(new Topping(price, flavour));
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return toppingList;
    }
    /**
     * Selects and returns all bottom-objects from the 'bottoms'-table in the database.
     * @return ArrayList of bottom-objects from database
     * @throws Exception if a connection or SQL error occurs
     */
    public static ArrayList<Bottom> bottoms() throws Exception{
        ArrayList<Bottom> bottomList = new ArrayList();
        int id = 0;
        String flavour = "";
        float price = 0;
        try{
        DBConnector con = new DBConnector();
        Connection connection = con.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT flavour, price FROM bottom;");
        
        while(rs.next()){
            flavour = rs.getString("flavour");
            price = rs.getFloat("price"); 
            
            bottomList.add(new Bottom(price, flavour));
        }
        }
        catch(Exception e)
        {
            
        }
            return bottomList;
    }
    /**
     * Selects and returns a specific topping-object from the 'topping'-table in the database.
     * @param flavour used in WHERE clause to find topping
     * @return topping defined by the flavour
     * @throws Exception if a connection or SQL error occurs
     */
    public static Topping getTopping(String flavour) throws Exception{
        Topping topping = null;
        for(Topping t : toppings())
        {
            if(t.getFlavour().equals(flavour))
            {
                topping = t;
            }
        }
        return topping;
    }
    /**
     * Selects and returns a specific bottom-object from the 'bottom'-table in the database.
     * @param flavour used in WHERE clause to find bottom
     * @return bottom defined by the flavour
     * @throws Exception if a connection or SQL error occurs
     */
    public static Bottom getBottom(String flavour) throws Exception{
        Bottom bottom = null;
        for(Bottom b : bottoms())
        {
            if(b.getFlavour().equals(flavour))
            {
                bottom = b;
            }
        }
        return bottom;
    }
    
}
