/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Bottom;
import Data.CupCakeDAO;
import Data.Topping;
import Data.User;
import java.io.IOException;
import java.io.PrintWriter;
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

        User user = (User) request.getSession().getAttribute("user");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shop page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> User: " + user.getUsername()
                    + " Balance: " + user.getBalance() + "</h1>");
            out.println("<h1>Bottoms: <br> </h1>");

//            try {
//                for (Bottom b : CupCakeDAO.bottoms()) {
//                    out.println("<p> Flavour: " + b.getFlavour() + "Price: " + b.getPrice() + "</p>");
//                }
//                
//                out.print("<h1>Toppings: <br><br> </h1>");
//
//                for (Topping b : CupCakeDAO.toppings()) {
//                    out.println("<p> Flavour: " + b.getFlavour() + "Price: " + b.getPrice() + "</p>");
//                }
//
//            } catch (Exception e) {
//
//            }
            try
            {
                out.println("<table>");
                
                out.println("<tr>");
                out.println("<th> Flavour " + "</th>" );
                out.println("<th> Price " + "</th>");
                out.println("</tr>");
                
                for(Bottom b : CupCakeDAO.bottoms())
                {
                    out.println("<tr>");
                    out.println("<td>" + b.getFlavour() + "</td>");
                    out.println("<td>" + b.getPrice() + "</td>");
                    out.println("<td>");
                }
                
                out.println("</table>");
                out.print("<h1>Tuppongs: <br><br> </h1>");
                
                out.println("<table>");
                
                out.println("<tr>");
                out.println("<th> Flavour " + "</th>" );
                out.println("<th> Price " + "</th>");
                out.println("</tr>");
                
                for(Topping p : CupCakeDAO.toppings())
                {
                    out.println("<tr>");
                    out.println("<td>" + p.getFlavour() + "</td>");
                    out.println("<td>" + p.getPrice() + "</td>");
                    out.println("<td>");
                }
                
                out.println("</table>");
                
                
            }
            catch (Exception ex)
            {
                Logger.getLogger(ShopCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
