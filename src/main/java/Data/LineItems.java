/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 * Mirrors the lineitem-table in the database, and is instantiated in the
 * shoppingCart- and Order-mappers where a lineitem is returned and forwarded to the presentation-layer
 * where it is used to create an order/shoppingcart.
 * @author Younes
 */
public class LineItems
{
    private CupCake cup;
    private int quantity;
    
    public LineItems (CupCake selectedCupCake, int quantity)
    {
        this.cup = selectedCupCake;
        this.quantity = quantity;
    }

    public CupCake getCup() {
        return cup;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
