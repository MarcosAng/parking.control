package com.api.parking.control.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpotDto {
 
    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    
    @NotBlank
    private String responsableName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    @NotBlank
    private int numeroVagas;
}
