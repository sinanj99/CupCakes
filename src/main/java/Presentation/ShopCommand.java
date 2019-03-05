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
        
        if (request.getParameterMap().containsKey("add")) {
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
        else if(request.getParameterMap().containsKey("checkout"))
        {
            
        }
    }
}
//
//
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Shop page</title>");
//            out.println("</head>");
//            out.println("<body>");
//            /*out.println(cTop.getFlavour() + " " + cTop.getPrice() + "<br>");
//            out.println(cBot.getFlavour() + " " + cBot.getPrice() + "<br>");*/
//            out.println("<a href=\"/CupCakesProject/\">Tilbage til menu</a><br>");
//            out.println("<h1> User: " + user.getUsername()
//                    + " Balance: " + user.getBalance() + "</h1>");
//            out.println("<form action=\"\" method=\"get\">");
//            out.println("<input type=\"hidden\" name=\"button\" value=\"add\">");
//            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
//                    + "type=\"text\" name=\"bottom\" placeholder=\"Bund id\"><br><br>");
//            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
//                    + "type=\"text\" name=\"top\" placeholder=\"Top id\"><br><br>");
//            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
//                    + "type=\"text\" name=\"qty\" placeholder=\"Antal\"><br><br>");
//            out.println("<input style=\"border-radius: 3px; border: none; background-color: #35B4FF; color: #FFF; padding: 8px 10px;\" "
//                    + "type=\"submit\" value=\"Tilføj til kurv\">");
//            out.println("</form>");
//            
//            out.println("<h1>Bottoms: <br></h1>");
//
//            try
//            {
//                out.print("<br><br>");
//                out.println("<table>");
//                
//                out.println("<tr>");
//                out.println("<th> Flavour " + "</th>" );
//                out.println("<th> Price " + "</th>");
//                out.println("</tr>");
//                
//                int i = 1;
//                for(Bottom b : CupCakeDAO.bottoms())
//                {
//                    out.println("<tr id=\""+i+"\">");
//                    out.println("<td>" + i + ". " + b.getFlavour() + "</td>");
//                    out.println("<td>" + b.getPrice() + "</td>");
//                    out.println("</tr>");
//                    i++;
//                }
//                
//                out.println("</table>");
//                out.print("<h1>Tuppongs: <br><br> </h1>");
//                
//                out.println("<table>");
//                
//                out.println("<tr>");
//                out.println("<th> Flavour " + "</th>" );
//                out.println("<th> Price " + "</th>");
//                out.println("</tr>");
//                
//                int j = 1;
//                for(Topping p : CupCakeDAO.toppings())
//                {
//                    out.println("<tr id=\""+j+"\">");
//                    out.println("<td>" + j + ". " + p.getFlavour() + "</td>");
//                    out.println("<td>" + p.getPrice() + "</td>");
//                    out.println("</tr>");
//                    j++;
//                }
//                
//                out.println("</table>");
//                
//                ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingcart");
//                
//                out.println("<h4>Kurv</h4>");
//                out.println("<table border=\"1\">");
//                out.println("<tr>");
//                out.println("<th>Top</th>");
//                out.println("<th>Bund</th>");
//                out.println("<th>Antal</th>");
//                out.println("<th>Pris</th>");
//                
//                float fullPrice = 0;
//                for(LineItems lt : cart.getItems()){
//                    
//                    float lineItemPrice = (lt.getCup().getCupCakeTopping().getPrice() + lt.getCup().getCupCakeBottom().getPrice()) * lt.getQuantity();
//                    fullPrice += lineItemPrice;
//                    out.println("<tr>");
//                    out.println("<td>" + lt.getCup().getCupCakeTopping().getFlavour() + "</td>");
//                    out.println("<td>" + lt.getCup().getCupCakeBottom().getFlavour() + "</td>");
//                    out.println("<td>" + lt.getQuantity() + "</td>");
//                    out.println("<td>" + lineItemPrice + "</td>");
//                    out.println("</tr>");
//                    
//                }
//                out.println("<tr><td colspan=\"4\"  align=\"center\">Total pris: " + fullPrice + "</td></tr>");
//                out.println("</tr>");
//                
//            }
//            catch (Exception ex)
//            {
//                Logger.getLogger(ShopCommand.class.getName()).log(Level.SEVERE, null, ex);
//            }
//       
//        
//            
//            
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//
