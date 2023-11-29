package com.co.MauricioMunoz.PruebaTecnica.utilities;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    private final String expresionRegular="^.*$";



    public boolean isValidPassword(String password) {
        return password.matches(expresionRegular);
    }
}
