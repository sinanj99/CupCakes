/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 * Mirrors the invoice table in the database. Is instantiated in the presentation layer
 * in jsp files that show orders to admins and customers, and the database layer.
 * @author Obaydah Mohamad
 */
public class Order {
    private final int id;
    private String username;
    private String datePlaced;
    private ArrayList<LineItems> lineitems = new ArrayList();

    public Order(int id, String username, String datePlaced) {
        this.id = id;
        this.username = username;
        this.datePlaced = datePlaced;
    }    
    
    public Order(int id, String username, String datePlaced, ArrayList<LineItems> lineitems) {
        this.id = id;
        this.username = username;
        this.datePlaced = datePlaced;
        this.lineitems = lineitems;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public ArrayList<LineItems> getLineitems() {
        return lineitems;
    }
    
    
}
