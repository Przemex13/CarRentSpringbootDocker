package com.example.CarRentSpringbootDocker.service;

import com.example.CarRentSpringbootDocker.entity.Car;
import com.example.CarRentSpringbootDocker.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        Logger logger1 = LoggerFactory.getLogger(CarService.class);
    }

    public Car saveCar(Car car){
        return this.carRepository.save(car);
    }

    public void deleteCar (Long id){
        carRepository.deleteById(id);
    }

    public Optional<Car> findCarById (Long carId){
        return carRepository.findById(carId);
    }
}
