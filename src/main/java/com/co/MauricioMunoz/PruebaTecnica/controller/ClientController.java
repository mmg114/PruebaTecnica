package com.co.MauricioMunoz.PruebaTecnica.controller;

import com.co.MauricioMunoz.PruebaTecnica.dto.request.ClientDTORequest;

import com.co.MauricioMunoz.PruebaTecnica.dto.response.ClientDTOResponse;
import com.co.MauricioMunoz.PruebaTecnica.service.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    IClienteServices clienteServices;


    @PostMapping
    public ResponseEntity<ClientDTOResponse> createUser( @RequestBody ClientDTORequest clientDTORequest) {
        return new ResponseEntity<>(clienteServices.create(clientDTORequest), HttpStatus.ACCEPTED);
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTOResponse> getUser(@PathVariable UUID clientId) {
        return new ResponseEntity<>(clienteServices.getClient(clientId), HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTOResponse> updateUser(@PathVariable UUID clientId,  @RequestBody ClientDTORequest clientDTORequest) {
        return new ResponseEntity<>(clienteServices.updateClient(clientId,clientDTORequest), HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID clientId) {

        clienteServices.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
