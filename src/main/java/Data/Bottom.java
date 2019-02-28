/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Younes
 */
public class Bottom {
    
    private float price;
    private String flavour;

    public Bottom(float price, String flavour) {
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
