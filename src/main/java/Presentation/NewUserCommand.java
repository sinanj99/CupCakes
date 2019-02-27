/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Data.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class NewUserCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            float balance = Float.valueOf(request.getParameter("balance"));

            UserDAO.insertUser(username, password, balance);
            String addedUser = UserDAO.getUser(username).getUsername();

            response.setContentType("text/html;charset=UTF-8");
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LoginServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User, " + addedUser + " has been registered in the system!</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
    }

