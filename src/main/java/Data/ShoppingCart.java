/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 * Instantiated in ShopCommand where a session with a shopping cart is created,
 * forwarded to products.jsp and displayed to the customer. 
 * @author Kasper Jeppesen
 */
public class ShoppingCart
{
    ArrayList<LineItems> items = new ArrayList<>();

    public ArrayList<LineItems> getItems() {
        return items;
    }
}
