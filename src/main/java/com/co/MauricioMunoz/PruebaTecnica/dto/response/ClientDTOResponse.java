package com.co.MauricioMunoz.PruebaTecnica.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
@Builder
public class ClientDTOResponse {

    private UUID id;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private UUID token;
    private boolean isActive;
}
