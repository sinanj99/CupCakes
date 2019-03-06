/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.LineItems;
import Data.ShoppingCart;
import Data.User;
import Data.UserDAO;
import Data.shoppingCartDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class CheckoutCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getUsername());
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingcart");

        float fullPrice = 0;

        for (LineItems lt : cart.getItems()) {
            float lineItemPrice = (lt.getCup().getCupCakeTopping().getPrice() + lt.getCup().getCupCakeBottom().getPrice()) * lt.getQuantity();
            fullPrice += lineItemPrice;
        }

        if (user.getBalance() < fullPrice) {
            request.getRequestDispatcher("insufficient_funds.jsp").forward(request, response);
        } else {
            shoppingCartDAO.insertOrder(user, cart.getItems());
            float newBalance = user.getBalance() - fullPrice;
            UserDAO.setBalance(user.getUsername(), newBalance);
            user.setBalance(newBalance);
        }

    }
}
