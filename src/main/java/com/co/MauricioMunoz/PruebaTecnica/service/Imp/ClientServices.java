package com.co.MauricioMunoz.PruebaTecnica.service.Imp;

import com.co.MauricioMunoz.PruebaTecnica.dto.request.ClientDTORequest;
import com.co.MauricioMunoz.PruebaTecnica.dto.response.ClientDTOResponse;
import com.co.MauricioMunoz.PruebaTecnica.mapper.ClientMapper;
import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import com.co.MauricioMunoz.PruebaTecnica.repository.ClientRepository;
import com.co.MauricioMunoz.PruebaTecnica.service.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServices implements IClienteServices {


    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServices(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;

    }

    @Override
    public ClientDTOResponse create(ClientDTORequest clientDTORequest) {
        Client clientTmp = ClientMapper.convertToEntity(clientDTORequest);
        Client tieneCorre =clientRepository.findByEmail(clientTmp.getEmail());
        if (tieneCorre.getEmail()!= null){
            throw new RuntimeException("Ya existe un Cliente con ese correo");
        }
        return createResponse(clientRepository.save(clientTmp));
    }

    @Override
    public void deleteClient(UUID clientId) {

    }

    @Override
    public ClientDTOResponse updateClient(ClientDTORequest clientDTORequest) {
        return null;
    }

    @Override
    public ClientDTOResponse getClient(UUID clientId) {
        return  createResponse(clientRepository.findById(clientId));

    }

    private ClientDTOResponse createResponse(Client cliente) {

        return
                ClientDTOResponse
                        .builder()
                        .id(cliente.getId())
                        .created(new Date())
                        .isActive(true)
                        .token(UUID.randomUUID()).build();
    }


}
