/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.User;
import Data.UserDAO;

/**
 * Is called from LoginCommand and RegistrationCommand which forwards user-input
 * for this class to validate.
 * @author sinanjasar
 */
public class LoginController {

    /**
     * Checks if inserted password matches password for the user with the specified
     * username in the database. 
     * @param username username of the user whose password needs validation.
     * @param password password of the user that needs validation.
     * @return boolean
     */
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
    /**
     * Calls UserDAO().getUser(username)
     * @param username param of called method
     * @return a User
     */
    public static User getUser(String username) {
        return new UserDAO().getUser(username);
    }
    /**
     * Checks if user already exists in the database.
     * @param username the username of the user. 
     * @return boolean
     */
    public static boolean duplicate(String username) {
        return UserDAO.getUser(username).getUsername().equals(username);
    }
}
