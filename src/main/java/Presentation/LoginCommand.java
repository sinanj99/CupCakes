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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receives input from login.jsp, validates this input with the use of
 * methods from LoginController, and eventually,
 * if the input is valid, creates a session with the user and forwards user to index.jsp. 
 * If the input is invalid an error-message is forwarded to login.jsp.
 * @author sinanjasar
 */
public class LoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        System.out.println(LoginController.isValid(username, password));
        if(LoginController.isValid(username, password)) {
            user = LoginController.getUser(username);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/CupCakesProject/index.jsp");
        }else{
            request.getSession().setAttribute("loginResult", "loginFailed");
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            
            //response.sendRedirect("/CupCakesProject/login.jsp");
        }
    }

}
