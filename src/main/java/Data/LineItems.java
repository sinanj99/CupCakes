/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Kasper Jeppesen
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
