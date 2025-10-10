package com.api.parking.control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parking.control.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    
}
