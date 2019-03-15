/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 * Consists of topping, bottom and total price of the topping and bottom combined.
 * Is used in ShopCommand where a LineItem object is created which consists of a Cupcake object
 * and quantity.
 * @author Younes
 */
public class CupCake {
    
    private Topping cupCakeTopping;
    private Bottom cupCakeBottom;
    private final float totalPrice;

    public CupCake(Topping cupCakeTopping, Bottom cupCakeButtom) {
        this.cupCakeTopping = cupCakeTopping;
        this.cupCakeBottom = cupCakeButtom;
        this.totalPrice = cupCakeTopping.getPrice() + cupCakeBottom.getPrice();
    }

    @Override
    public String toString() {
        return "CupCake{" + "cupCakeTopping=" + cupCakeTopping + ", cupCakeBottom=" + cupCakeBottom + ", totalPrice=" + totalPrice + '}';
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Topping getCupCakeTopping() {
        return cupCakeTopping;
    }

    public Bottom getCupCakeBottom() {
        return cupCakeBottom;
    }
    
    
    
}
