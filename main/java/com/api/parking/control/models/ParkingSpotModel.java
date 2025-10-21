package com.api.parking.control.models;

import java.io.Serializable;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.JoinColumn;
import com.api.parking.control.models.CarModel;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PARKING_SPOT")
@Setter
@Getter
public class ParkingSpotModel implements Serializable{

    @SuppressWarnings("unused")
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsableName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;

    @Column(nullable = false, length = 10)
     private int numeroVagas;

    //um estacionamento pode ter varios carros    
    @OneToMany(mappedBy = "parkingSpotModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarModel> cars;
}
