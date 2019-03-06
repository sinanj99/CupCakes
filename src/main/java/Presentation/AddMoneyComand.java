/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Data.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public class AddMoneyComand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String balance = request.getParameter("newbalance");
        float balance_ = 0;
        try {
            balance_ = Float.parseFloat(balance);
            if(balance_ < 0)
            {
                request.getSession().setAttribute("balanceResult", "negativeInput");
                RequestDispatcher rd = request.getRequestDispatcher("increasebalance.jsp");
                rd.forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("balanceResult", "invalidInput");
            RequestDispatcher rd = request.getRequestDispatcher("increasebalance.jsp");
            rd.forward(request, response);
        }

        UserDAO.setBalance(user.getUsername(), Float.parseFloat(balance)+user.getBalance());
        user.setBalance(Float.parseFloat(balance) + user.getBalance());
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }

}
