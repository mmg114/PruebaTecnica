package com.co.MauricioMunoz.PruebaTecnica.service.Imp;

import com.co.MauricioMunoz.PruebaTecnica.dto.ClientDTO;
import com.co.MauricioMunoz.PruebaTecnica.mapper.ClientMapper;
import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import com.co.MauricioMunoz.PruebaTecnica.repository.ClientRepository;
import com.co.MauricioMunoz.PruebaTecnica.service.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices implements IClienteServices {


    private final   ClientRepository clientRepository;
    private final   ClientMapper clientMapper;

    @Autowired
    public ClientServices(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;

    }
    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        Client clientTmp = ClientMapper.convertToEntity(clientDTO);
        //TODO eerror  de correo ya registrado
        return   clientMapper.convertToDTO(clientRepository.save(clientTmp));
    }
}
