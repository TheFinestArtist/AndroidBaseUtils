package com.thefinestartist.utils.etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TheFinestArtist on 2/18/16.
 */
public class Validator {

    public static boolean isEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}