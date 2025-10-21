package com.api.parking.control.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_CARRO")
@Setter
@Getter
public class CarModel implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String owner;

    @Column(nullable = false, length = 8)
    private String placa;
    
    @Column(nullable = false, length = 70)
    private String brandCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false, length=10)
    private int yearCar;

    @Column(nullable = false, length=10)
    private int yearModelCar;

    @ManyToOne
    @JoinColumn(name = "parkingSpotModel_id")    
    private ParkingSpotModel parkingSpotModel;

}
