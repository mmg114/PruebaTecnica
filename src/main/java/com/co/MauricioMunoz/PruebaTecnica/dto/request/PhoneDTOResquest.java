package com.co.MauricioMunoz.PruebaTecnica.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class PhoneDTOResquest {
    @NotBlank(message = "Debe ingresar un numero Telefonico" )
    @NotNull(message = "Debe ingresar un numero Telefonico" )
    private String number;
    @JsonProperty("citycode")
    @NotNull(message = "Debe ingresar un Indicativo de ciudad" )
    private String cityCode;
    @JsonProperty("contrycode")
    @NotNull(message = "Debe ingresar un Indicativo de Estado" )
    private String contryCode;


}
