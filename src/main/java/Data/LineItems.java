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
    // for opgave 6
    private static int invoiceId = 1;
    private CupCake cup;
    private int quantity;
    
    public LineItems (CupCake selectedCupCake, int quantity)
    {
        this.cup = selectedCupCake;
        this.quantity = quantity;
        
        invoiceId++; //Skal først increases idet, der betales for ordren - derfor skal den ikke være her!!
    }
    
    
    
}
