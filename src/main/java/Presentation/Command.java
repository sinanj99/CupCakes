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
 *
 * @author sinanjasar
 */
public abstract class Command {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public static Command from(HttpServletRequest request) {
        Command c;
        
        String origin = request.getParameter("command");
        
        Map<String, Command> commands = new HashMap();
        commands.put("shop", new ShopCommand());
        commands.put("default", new DefaultCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("login", new LoginCommand());
        
        c = commands.getOrDefault(origin, new UnknownCommand());
        
        return c;
    }
    
    
}

