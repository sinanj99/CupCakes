/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Bottom;
import Data.CupCake;
import Data.CupCakeDAO;
import Data.LineItems;
import Data.Topping;
import Data.shoppingCart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class ProductControl extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        
        int qty = Integer.valueOf(request.getParameter("qty"));
        
        Topping topping_ = null;
        Bottom bottom_ = null;
        
        try{
        topping_ = CupCakeDAO.getTopping(topping);
        bottom_ = CupCakeDAO.getBottom(bottom);
        }
        
        catch(Exception e)
        {}
        
        CupCake cup = new CupCake(topping_, bottom_);
        
        LineItems l = new LineItems(cup, qty);
        
        List<LineItems> s = new shoppingCart().getItems();
        
        request.getSession().setAttribute("shoppingcart", s);
        
        s.add(l);
        
    }
    
}
