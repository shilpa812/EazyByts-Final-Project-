package com.example.carrental.controller;

import com.example.carrental.model.Car;
import com.example.carrental.service.CarService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car-list";
    }

    @GetMapping("/cars/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "car-details";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/cars/new")
    public String createCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "car-form";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/cars")
    public String saveCar(@ModelAttribute Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/cars/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "car-form"; // Reuse car-form template for editing
    }

    // Update the existing car (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/cars/edit/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute Car car) {
        car.setCarId(id); // Ensure the ID is set for update
        carService.saveCar(car); // Assuming saveCar handles both create and update
        return "redirect:/cars";
    }

    // Delete a car (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/cars/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
