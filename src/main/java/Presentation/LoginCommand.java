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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (LoginController.isValid(username, password)) {
            user = LoginController.getUser(username);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/CupCakesProject/index.jsp");
        }else{
            response.sendRedirect("/CupCakesProject/login.jsp");
        }
    }

}
