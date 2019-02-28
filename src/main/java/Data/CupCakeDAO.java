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
    
    private DBConnector con = null;
    
    public ArrayList<Topping> toppings() throws Exception{
        ArrayList<Topping> toppingList = new ArrayList<>();
        String flavour = "";
        float price = 0;
        
        con = new DBConnector();
        Connection connection = con.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT flavour, price FROM cupcakeTopping;");
        
        while(rs.next()){
            flavour = rs.getString(2);
            price = rs.getFloat(3); 
            
            toppingList.add(new Topping(price, flavour));
        
        }
            return toppingList;
    }
    
    public ArrayList<Bottom> bottoms() throws Exception{
        ArrayList<Bottom> bottomList = new ArrayList<>();
        String flavour = "";
        float price = 0;
        
        con = new DBConnector();
        Connection connection = con.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT flavour, price FROM cupcakeBottom;");
        
        while(rs.next()){
            flavour = rs.getString(2);
            price = rs.getFloat(3); 
            
            bottomList.add(new Bottom(price, flavour));
        
        }
            return bottomList;
    }
    
}
