package com.co.MauricioMunoz.PruebaTecnica.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ClientDTO {

    private UUID id;
    @NotNull(message = "Debe ingresar un nombre de Cliente")
    private String name;
    @NotNull(message = "Debe ingresar un correo")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@dominio\\.cl$",message = "Debe ingresar un correo en el siguente formato {Usuario}@dominio.cl")
    private String email;
    @NotNull(message = "Debe ingresar una contraseña")
    private String password;
    private List<PhoneDTO> phones;
}
