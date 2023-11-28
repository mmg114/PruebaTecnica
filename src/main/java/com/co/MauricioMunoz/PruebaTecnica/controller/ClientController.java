package com.co.MauricioMunoz.PruebaTecnica.controller;

import com.co.MauricioMunoz.PruebaTecnica.dto.ClientDTO;

import com.co.MauricioMunoz.PruebaTecnica.service.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    IClienteServices clienteServices;


    @PostMapping
    public ResponseEntity<ClientDTO> createUser( @Valid @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clienteServices.create(clientDTO), HttpStatus.ACCEPTED);
    }
}
