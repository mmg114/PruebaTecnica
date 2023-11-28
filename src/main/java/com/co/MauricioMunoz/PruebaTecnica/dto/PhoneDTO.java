package com.co.MauricioMunoz.PruebaTecnica.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotNull;

@Data
@Builder
public class PhoneDTO {
    @NotNull(message = "Debe ingresar un numero Telefonico" )
    private String number;
    @JsonProperty("citycode")
    @NotNull(message = "Debe ingresar un Indicativo de ciudad" )
    private String cityCode;
    @JsonProperty("contrycode")
    @NotNull(message = "Debe ingresar un Indicativo de Estado" )
    private String contryCode;


}
