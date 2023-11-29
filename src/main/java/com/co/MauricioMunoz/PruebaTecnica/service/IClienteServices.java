package com.co.MauricioMunoz.PruebaTecnica.service;

import com.co.MauricioMunoz.PruebaTecnica.dto.request.ClientDTORequest;
import com.co.MauricioMunoz.PruebaTecnica.dto.response.ClientDTOResponse;

import java.util.UUID;

public interface IClienteServices {
   ClientDTOResponse create(ClientDTORequest clientDTORequest);

   void deleteClient(UUID clientId);

   ClientDTOResponse updateClient(ClientDTORequest clientDTORequest);

   ClientDTOResponse getClient(UUID clientId);
}
