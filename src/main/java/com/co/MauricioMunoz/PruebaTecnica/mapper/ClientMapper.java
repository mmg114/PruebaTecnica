package com.co.MauricioMunoz.PruebaTecnica.mapper;

import com.co.MauricioMunoz.PruebaTecnica.dto.ClientDTO;
import com.co.MauricioMunoz.PruebaTecnica.dto.PhoneDTO;
import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import com.co.MauricioMunoz.PruebaTecnica.model.Phone;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
@Component
public class ClientMapper {


        public static Client convertToEntity(ClientDTO clientDTO) {
            return  Client.builder()
                    .name(clientDTO.getName())
                    .email(clientDTO.getEmail())
                    .password(clientDTO.getPassword())
                    .phones(convertToPhoneList(clientDTO.getPhones()))
                    .build();
        }

        private static List<Phone> convertToPhoneList(List<PhoneDTO> phoneDTOs) {
            if (phoneDTOs != null) {
                return phoneDTOs.stream()
                        .map(ClientMapper::convertToEntity)
                        .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        public static Phone convertToEntity(PhoneDTO phoneDTO) {
            return Phone.builder()
                    .number(phoneDTO.getNumber())
                    .cityCode(phoneDTO.getCityCode())
                    .countryCode(phoneDTO.getContryCode())
                    .build();
        }

    public ClientDTO convertToDTO(Client client) {
        return  ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .password(client.getPassword())
                .phones(convertToPhoneDTOList(client.getPhones()))
                .build();
    }

    private List<PhoneDTO> convertToPhoneDTOList(List<Phone> phones) {
        if (phones != null) {
            return phones.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public PhoneDTO convertToDTO(Phone phone) {
        return PhoneDTO.builder()
                .number(phone.getNumber())
                .cityCode(phone.getCityCode())
                .contryCode(phone.getCountryCode())
                .build();
    }
    }