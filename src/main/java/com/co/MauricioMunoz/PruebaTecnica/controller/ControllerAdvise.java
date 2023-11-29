package com.co.MauricioMunoz.PruebaTecnica.controller;

import com.co.MauricioMunoz.PruebaTecnica.dto.ErrorDTO;
import com.co.MauricioMunoz.PruebaTecnica.exception.BussinesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ErrorDTO.builder().mensaje("No se recibio ningun body en la peticion").build());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
            ErrorDTO errorDTO = ErrorDTO.builder().mensaje(ex.getMessage()).build();
            return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BussinesException.class)
    public ResponseEntity<ErrorDTO> bussinesExceptionHandler(BussinesException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }
}
