/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sinanjasar
 */

    public class PasswordChecker {
    public static final Pattern VALID_PASSWORD_REGEX = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX .matcher(password);
        return matcher.find();
}
}