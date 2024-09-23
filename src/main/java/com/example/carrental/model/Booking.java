package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long userId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "carId",  referencedColumnName = "carId",insertable = false, updatable = false)
    private Car car;

    // Getters and Setters
}
