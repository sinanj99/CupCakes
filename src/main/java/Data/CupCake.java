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
public class CupCake {
    
    private Topping cupCakeTopping;
    private Bottom cupCakeBottom;
    private final float totalPrice = cupCakeTopping.getPrice() + cupCakeBottom.getPrice();

    public CupCake(Topping cupCakeTopping, Bottom cupCakeButtom) {
        this.cupCakeTopping = cupCakeTopping;
        this.cupCakeBottom = cupCakeButtom;
    }
    
    
    
}
