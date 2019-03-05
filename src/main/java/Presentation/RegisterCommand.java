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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obaydah Mohamad
 */
public class RegisterCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        
        if(user != null){
            response.sendRedirect("/CupCakesProject/index.jsp");
        }else{
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserDAO.insertUser(username, password, 0);
            session.setAttribute("user", user);
            response.sendRedirect("/CupCakesProject/index.jsp");
        }
    }
    
}
