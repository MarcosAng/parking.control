package com.api.parking.control.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    @NotBlank
    @Size(max = 8)
    private String placa;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String owner;
     
    //@NotBlank
    private int yearCar;

    //@NotBlank
    private int yearModelCar;
    

}
