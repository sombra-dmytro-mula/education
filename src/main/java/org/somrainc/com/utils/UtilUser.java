package org.somrainc.com.utils;

import com.google.common.base.Strings;
import org.somrainc.com.model.User;

import java.util.regex.Pattern;

public class UtilUser {

    public static String changeUserName(boolean howChange, User user) {
        if (howChange) {
            return user.getUsername().toLowerCase();
        }
        return user.getUsername().toUpperCase();
    }

    public static boolean isValidEmail(String email) {
        if (Strings.isNullOrEmpty(email)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }



}
