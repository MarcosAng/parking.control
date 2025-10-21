package com.api.parking.control.services;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parking.control.models.CarModel;
import com.api.parking.control.repositories.CarRepository;

import jakarta.transaction.Transactional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Transactional
    public CarModel save(CarModel carModel) {
        return carRepository.save(carModel);
    }

    public boolean existsByPlaca(String placa) {
        return carRepository.existsByPlaca(placa);
    }

    public Page<CarModel> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);     
    }

    public Optional<CarModel> findById(UUID id) {
        return carRepository.findById(id);
    }

    @Transactional
    public void delete(CarModel carModel) {
        carRepository.delete(carModel);
    }


}
