package com.api.parking.control.controllers;

import java.util.Optional;
import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.parking.control.dtos.CarDto;
import com.api.parking.control.models.CarModel;
import com.api.parking.control.services.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody @Valid CarDto carDto) {
        //isolar essas validacoes em um customValidator
        if(carService.existsByPlaca(carDto.getPlaca())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Esse carro já existe!");
        }

        var carModel  = new CarModel();
        BeanUtils.copyProperties(carDto, carModel);        
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carModel));
    }

    @GetMapping
    public ResponseEntity<Page<CarModel>> getAllCars(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCar(@PathVariable(value = "id") UUID id) {
        Optional<CarModel> carModelOptional = carService.findById(id);
        if(!carModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carModelOptional.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable(value = "id") UUID id) {
        Optional<CarModel> carModelOptional = carService.findById(id);
        if(!carModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        carService.delete(carModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Carro excluído com sucesso!");
    }

    @PutMapping("path/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable(value = "id") UUID id, @RequestBody @Valid CarDto carDto) {
        Optional<CarModel> carModelOptional = carService.findById(id);
        if(!carModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        var carModel = new CarModel();
        BeanUtils.copyProperties(carDto, carModel);
        carModel.setId(carModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(carService.save(carModel));
    }
}
