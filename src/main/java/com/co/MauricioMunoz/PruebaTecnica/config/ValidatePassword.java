package com.co.MauricioMunoz.PruebaTecnica.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
@Configuration
public class ValidatePassword {

    @Value("${clave.expresion-regular}")
    private String claveExpresionRegular;

    @Bean
    public String claveExpresionRegular() {
        return claveExpresionRegular;
    }
}
