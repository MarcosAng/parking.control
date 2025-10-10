package com.api.parking.control.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking.control.services.ParkingSpotService;


@RestController
@CrossOrigin()
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    ParkingSpotService parkingSpotService;

    
}
