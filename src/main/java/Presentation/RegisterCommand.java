/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Data.UserDAO;
import Logic.LoginController;
import Logic.PasswordChecker;
import Logic.UsernameChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receives input from registration.jsp, validates this input with the use of
 * methods from LoginController, PasswordChecker and UsernameChecker, and eventually,
 * if the input is valid, inserts user with given input to database 
 * and redirects to login.jsp. If the input is invalid an error-message is forwarded
 * to registration.jsp.
 * 
 * @author Obaydah Mohamad
 */
public class RegisterCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user != null) {
            response.sendRedirect("/CupCakesProject/index.jsp");
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            

            if (LoginController.duplicate(username)) {
                request.getSession().setAttribute("registerResult", "registerDuplicate");
                response.sendRedirect("/CupCakesProject/register.jsp");
                
            } else if (!PasswordChecker.validate(password)) {
                request.getSession().setAttribute("registerResult", "registerInvalidPassword");
                response.sendRedirect("/CupCakesProject/register.jsp");
            } else if(!UsernameChecker.validate(username)) {
                request.getSession().setAttribute("registerResult", "registerInvalidUsername");
                response.sendRedirect("/CupCakesProject/register.jsp");
                
        } else {
                
                UserDAO.insertUser(username, password, 0);
                request.getSession().setAttribute("registerResult", "registerSuccesful");
                response.sendRedirect("/CupCakesProject/login.jsp");
            }
    }
}

}
