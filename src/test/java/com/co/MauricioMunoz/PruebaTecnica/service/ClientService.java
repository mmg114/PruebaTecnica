package com.co.MauricioMunoz.PruebaTecnica.service;

import com.co.MauricioMunoz.PruebaTecnica.dto.request.ClientDTORequest;
import com.co.MauricioMunoz.PruebaTecnica.dto.request.PhoneDTOResquest;
import com.co.MauricioMunoz.PruebaTecnica.dto.response.ClientDTOResponse;
import com.co.MauricioMunoz.PruebaTecnica.exception.BussinesException;
import com.co.MauricioMunoz.PruebaTecnica.mapper.ClientMapper;
import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import com.co.MauricioMunoz.PruebaTecnica.model.Phone;
import com.co.MauricioMunoz.PruebaTecnica.repository.ClientRepository;
import com.co.MauricioMunoz.PruebaTecnica.service.Imp.ClientServices;
import com.co.MauricioMunoz.PruebaTecnica.utilities.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.UUID;

public class ClientService {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServices clientServices;

    @Mock
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {

        ClientDTORequest clientDTORequest = ClientDTORequest.builder()
                .name("Juan Rodriguez")
                .email("aaaaaaa@dominio.cl")
                .password("hunter2")
                .phones(Collections.singletonList(PhoneDTOResquest.builder()
                        .number("1234567")
                        .cityCode("1")
                        .contryCode("57")
                        .build()))
                .build();
        UUID randomUUID = UUID.randomUUID();

        when(clientRepository.findByEmail(clientDTORequest.getEmail())).thenReturn(null);
        when(clientMapper.convertToEntity(clientDTORequest)).thenReturn(Client.builder().id(randomUUID).email("aaaaaaa@dominio.cl").password("hunter2").build());
        when(passwordValidator.isValidPassword(anyString())).thenReturn(true);
        when(clientRepository.save(any(Client.class))).thenReturn(Client.builder().build());
        assertDoesNotThrow(() -> clientServices.create(clientDTORequest));
    }

    @Test
    void testCreate_DuplicateEmail() {

        ClientDTORequest clientDTORequest =ClientDTORequest.builder().email("test@example.com").password("123456").build();
        when(clientMapper.convertToEntity(clientDTORequest)).thenReturn(Client.builder().email("test@example.com").build());
        when(clientRepository.findByEmail(clientDTORequest.getEmail())).thenReturn(Client.builder().build());
        assertThrows(BussinesException.class, () -> clientServices.create(clientDTORequest));
    }

    @Test
    void testDeleteClient() {

        UUID clientId = UUID.randomUUID();
        when(clientRepository.findByIdAndActive(clientId,true)).thenReturn((Client.builder().build()));
        assertDoesNotThrow(() -> clientServices.deleteClient(clientId));
    }
    @Test
    void testUpdateClient() {

        ClientDTORequest clientDTORequest = ClientDTORequest.builder()
                .name("Juan Rodriguez")
                .email("mmsssg@rodriguez.org")
                .password("hunter2")
                .phones(Collections.singletonList(PhoneDTOResquest.builder()
                        .number("1234567")
                        .cityCode("1")
                        .contryCode("57")
                        .build()))
                .build();

        Client client = Client.builder()
                .name("Juan Rodriguez")
                .email("mmsssg@rodriguez.org")
                .password("hunter2")
                .phones(Collections.singletonList(Phone.builder()
                        .number("1234567")
                        .cityCode("1")
                        .countryCode("57")
                        .build()))
                .build();
        UUID clientId = UUID.randomUUID();
        Client clientFromRepository = Client.builder().build();
        when(clientMapper.convertToEntity(clientDTORequest)).thenReturn(Client.builder().email("test@example.com").build());
        when(clientRepository.findByIdAndActive(clientId,true)).thenReturn(client);
        when(clientRepository.save(any(Client.class))).thenReturn(clientFromRepository);

        ClientDTOResponse result = clientServices.updateClient(clientId, clientDTORequest);

        assertNotNull(result);
    }

    @Test
    void testGetClient() {

        UUID clientId = UUID.randomUUID();
        Client clientFromRepository = Client.builder().build();
        when(clientRepository.findByIdAndActive(clientId,true)).thenReturn(clientFromRepository);
        ClientDTOResponse result = clientServices.getClient(clientId);
        assertNotNull(result);
    }


}