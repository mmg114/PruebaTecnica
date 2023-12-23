package com.co.MauricioMunoz.PruebaTecnica.controller;

import com.co.MauricioMunoz.PruebaTecnica.dto.ErrorDTO;
import com.co.MauricioMunoz.PruebaTecnica.exception.BussinesException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = BussinesException.class)
    public ResponseEntity<ErrorDTO> bussinesExceptionHandler(BussinesException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje("Error en el envio del tipo de dato: " +ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = MissingPathVariableException.class)
    public ResponseEntity<ErrorDTO> missingPathVariableException(MissingPathVariableException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje("Error en el envio de parametros: " + ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ErrorDTO> invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje("La entidad no puede llegar null").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorDTO> nullPointerExcetion(NullPointerException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje("Error En la operacion Contactar con admin").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<ErrorDTO> JorgeError(IOException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().mensaje("Error En la operacion Contactar con admin").build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}


