/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates username.
 * @author sinanjasar
 */

    public class UsernameChecker {
    public static final Pattern VALID_USERNAME_REGEX = 
        Pattern.compile("^[a-z0-9_-]{3,15}$", Pattern.CASE_INSENSITIVE);
    /**
     * Checks if username of new user matches valid username-regex.
     * @param username username of new user
     * @return boolean
     */
    public static boolean validate(String username) {
        Matcher matcher = VALID_USERNAME_REGEX .matcher(username);
        return matcher.find();
}
}