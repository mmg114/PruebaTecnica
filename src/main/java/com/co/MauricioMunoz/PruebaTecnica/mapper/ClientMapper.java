package com.co.MauricioMunoz.PruebaTecnica.mapper;

import com.co.MauricioMunoz.PruebaTecnica.dto.request.ClientDTORequest;
import com.co.MauricioMunoz.PruebaTecnica.dto.request.PhoneDTOResquest;
import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import com.co.MauricioMunoz.PruebaTecnica.model.Phone;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
@Component
public class ClientMapper {


        public static Client convertToEntity(ClientDTORequest clientDTORequest) {
            return  Client.builder()
                    .name(clientDTORequest.getName())
                    .email(clientDTORequest.getEmail())
                    .password(clientDTORequest.getPassword())
                    .phones(convertToPhoneList(clientDTORequest.getPhones()))
                    .build();
        }

        private static List<Phone> convertToPhoneList(List<PhoneDTOResquest> phoneDTOResquests) {
            if (phoneDTOResquests != null) {
                return phoneDTOResquests.stream()
                        .map(ClientMapper::convertToEntity)
                        .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        public static Phone convertToEntity(PhoneDTOResquest phoneDTOResquest) {
            return Phone.builder()
                    .number(phoneDTOResquest.getNumber())
                    .cityCode(phoneDTOResquest.getCityCode())
                    .countryCode(phoneDTOResquest.getContryCode())
                    .build();
        }

    public ClientDTORequest convertToDTO(Client client) {
        return  ClientDTORequest.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .password(client.getPassword())
                .phones(convertToPhoneDTOList(client.getPhones()))
                .build();
    }

    private List<PhoneDTOResquest> convertToPhoneDTOList(List<Phone> phones) {
        if (phones != null) {
            return phones.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public PhoneDTOResquest convertToDTO(Phone phone) {
        return PhoneDTOResquest.builder()
                .number(phone.getNumber())
                .cityCode(phone.getCityCode())
                .contryCode(phone.getCountryCode())
                .build();
    }
    }