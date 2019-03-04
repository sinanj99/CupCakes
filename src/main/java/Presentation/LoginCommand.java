/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Data.UserDAO;
import Logic.LoginController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sinanjasar
 */
public class LoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        //User user = (User) request.getSession().getAttribute("user");
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/CupCakesProject/default");
        }

        String buttonPressed = request.getParameter("button");

        boolean userValid = false;

        if (buttonPressed != null && buttonPressed.equals("login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (LoginController.isValid(username, password)) {
                user = LoginController.getUser(username);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                userValid = true;
                response.sendRedirect("/CupCakesProject/default");
            }
        }

        if (buttonPressed != null && buttonPressed.equals("newuser")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO.insertUser(username, password, 0);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LoginServlet</h1>");

            if (!userValid && buttonPressed != null && buttonPressed.equals("login")) {
                out.println("Ku ik logind<br>");
            }

            out.println("<br>Log ind<br>");
            out.println("<form method=\"get\" action=\"\">");
            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
                    + "type=\"text\" name=\"username\" placeholder=\"Brugernavn\"><br><br>");
            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
                    + "type=\"text\" name=\"password\" placeholder=\"Adgangskode\"><br><br>");
            out.println("<input style=\"border-radius: 3px; border: none; background-color: #35B4FF; color: #FFF; padding: 8px 10px;\" "
                    + "type=\"submit\" value=\"Log ind\">");
            out.println("<input type=\"hidden\" name=\"button\" value=\"login\">");
            out.println("</form>");
            out.println("<br>Opret bruger<br>");
            out.println("<form method=\"get\" action=\"\">");
            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
                    + "type=\"text\" name=\"username\" placeholder=\"Brugernavn\"><br><br>");
            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
                    + "type=\"text\" name=\"password\" placeholder=\"Adgangskode\"><br><br>");
            out.println("<input style=\"width: 173px; height: 25px; padding: 5px; border: 1px solid #a1a1a1; border-radius: 3px;\" "
                    + "type=\"text\" name=\"balance\" placeholder=\"Balance\"><br><br>");
            out.println("<input style=\"border-radius: 3px; border: none; background-color: #35B4FF; color: #FFF; padding: 8px 10px;\" "
                    + "type=\"submit\" value=\"Opret bruger\">");
            out.println("<input type=\"hidden\" name=\"button\" value=\"newuser\">");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

}
