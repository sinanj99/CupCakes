/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinanjasar
 */
public abstract class Command {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public static Command from(HttpServletRequest request) {
        Command c;
        String path = request.getPathInfo().substring(1);
        switch (path) {
            case "login": c = new NewUserCommand(); break;
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/LoginServlet");
//        dispatcher.forward(request, response);
            default: c = new UnknownCommand();
        }
        return c;
    }
}

