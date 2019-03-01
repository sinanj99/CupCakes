/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class DefaultCommand extends Command {

    public DefaultCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/CupCakesProject/LoginServlet");
        }
        User user = (User) request.getSession().getAttribute("user");
        try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Default page</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Velkommen " + user.getUsername() + "</h1>");
                    out.println("<b>Balance:</b> " + user.getBalance() + "<br>");
                    out.println("<ul>");
                    out.println("<li><a href=\"/CupCakesProject/shop\">Gå til shop</a></li>");
                    out.println("<li><a href=\"/CupCakesProject/shop\">Mine ordre</a></li>");
                    out.println("<li><a href=\"/CupCakesProject/logout\">Log ud</a></li>");
                    out.println("</ul>");
                    out.println("</body>");
                    out.println("</html>");
                }
    }
    
}
