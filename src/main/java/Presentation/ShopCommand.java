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
import Data.ShoppingCart;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class ShopCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("shoppingcart") == null) {
            request.getSession().setAttribute("shoppingcart", new ShoppingCart());
        }
        try {
            String topping = request.getParameter("topping");
            String bottom = request.getParameter("bottom");
            String qty = request.getParameter("qty");

            Topping top_ = CupCakeDAO.getTopping(topping);
            Bottom bottom_ = CupCakeDAO.getBottom(bottom);

            ShoppingCart cart_ = (ShoppingCart) request.getSession().getAttribute("shoppingcart");
            cart_.getItems().add(new LineItems(new CupCake(top_, bottom_), Integer.parseInt(qty)));

            request.getRequestDispatcher("products.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ShopCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
