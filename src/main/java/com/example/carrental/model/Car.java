package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long carId;
    private String make;
    private String model;
    private int year;
    private double pricePerDay;
    private String imageUrl;
    private boolean availability;

    // Getters and Setters
}
