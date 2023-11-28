package com.co.MauricioMunoz.PruebaTecnica.exception;

import lombok.Data;

public class BussinesException extends RuntimeException{

    public BussinesException(String message){
        super(message);
    }
}
