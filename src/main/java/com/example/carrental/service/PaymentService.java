package com.example.carrental.service;

import com.example.carrental.model.Payment;
import com.example.carrental.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }
    public void updatePayment(Long id, Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}


