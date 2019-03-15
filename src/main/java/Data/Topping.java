/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 * Mirrors the topping-table in the database, and is primarily instantiated in the
 * CupCake mappers where a cupcake is returned and forwarded to the presentation-layer
 * where the Shop- and CheckoutCommand use it to create LineItems and shoppingcarts
 * @author Younes
 */
public class Topping {
    
    private float price;
    private String flavour;

    public Topping(float price, String flavour) {
        this.price = price;
        this.flavour = flavour;
    }

    public float getPrice() {
        return price;
    }

    public String getFlavour() {
        return flavour;
    }
    
    
}
