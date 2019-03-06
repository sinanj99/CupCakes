/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.User;
import Data.UserDAO;
import java.util.List;

/**
 *
 * @author sinanjasar
 */
public class LoginController {

    public static boolean isValid(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        User user = new UserDAO().getUser(username);
        return password.equals(user.getPassword());
    }

    public static User getUser(String username) {
        return new UserDAO().getUser(username);
    }

    public static boolean duplicate(String username) {
        return UserDAO.getUser(username).getUsername().equals(username);
    }
}
