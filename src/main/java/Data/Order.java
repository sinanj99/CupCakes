/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author Obaydah Mohamad
 */
public class Order {
    private final int id;
    private String username;
    private String datePlaced;
    private ArrayList<CupCake> lineitems = new ArrayList<CupCake>();

    public Order(int id, String username, String datePlaced) {
        this.id = id;
        this.username = username;
        this.datePlaced = datePlaced;
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

    public ArrayList<CupCake> getLineitems() {
        return lineitems;
    }
    
    
}
