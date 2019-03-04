/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import DB.DBConnector;
import DB.DataBaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Younes
 */
public class CupCakeDAO {
    
    public static ArrayList<Topping> toppings() throws Exception{
        
        ArrayList<Topping> toppingList = new ArrayList();
        int id = 0;
        String flavour = "";
        float price = 0;
        
        try{
        DBConnector con = new DBConnector();
        Connection connection = con.getConnection();
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
            
        }
            return toppingList;
    }
    
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
