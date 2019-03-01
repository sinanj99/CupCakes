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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper Jeppesen
 */
public class shoppingCartDAO
{
    //Returntypen skal være????? ikke void ihvertfald
    public void InvoiceAndLineItems()
    {
        try
        {
            DBConnector con = new DBConnector();
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("insert statement is missing");
            
            while(rs.next())
            {
                //something here
            }
            
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(shoppingCartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
