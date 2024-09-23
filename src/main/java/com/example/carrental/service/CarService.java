package com.example.carrental.service;

import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
