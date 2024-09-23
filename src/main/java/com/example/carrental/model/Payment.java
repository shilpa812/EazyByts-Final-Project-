package com.example.carrental.model;

import java.time.LocalDateTime;

import com.example.carrental.enums.PaymentStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}
