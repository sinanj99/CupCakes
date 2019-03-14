/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command is the abstract base class for all Commands, including the abstract
 * execute method, which receives and processes requests from jsp pages and forwards
 * to jsp pages. 
 * @author sinanjasar
 */
public abstract class Command {
    /**
     * Abstract execute method which defines what to be done with the request and
     * response in the respecitive commands. Usually processes input from jsp-files
     * and redirects to other jsp-files.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException ServletException if a servlet-specific error occurs
     * @throws IOException IOException if an I/O error occurs
     */
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * Searches request for the value of parameter 'command', then checks the 
     * commands-map for a key with the same value and returns the value for the key.
     * @param request servlet request 
     * @return the correct Command
     */
    
    public static Command from(HttpServletRequest request) {
        
        Command c;
        
        String origin = request.getParameter("command");
        
        Map<String, Command> commands = new HashMap();
        commands.put("shop", new ShopCommand());
        commands.put("default", new DefaultCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("checkout", new CheckoutCommand());
        commands.put("increasebalance", new AddMoneyComand());
        
        c = commands.getOrDefault(origin, new UnknownCommand());
        
        return c;
    }
    
    
}

