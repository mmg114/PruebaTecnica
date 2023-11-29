package com.co.MauricioMunoz.PruebaTecnica.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  EmailValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]{0,30}@dominio.cl$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}