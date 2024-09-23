package com.example.carrental.controller;

import com.example.carrental.model.Payment;
import com.example.carrental.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String getAllPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments";
    }

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(id));
        return "payment";
    }
    @GetMapping("/create")
    public String createPayment(Model model) {
        model.addAttribute("payment", new Payment());
        return "create-payment";
    }

    @PostMapping
    public String savePayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/{id}/update")
    public String updatePayment(@PathVariable Long id, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(id));
        return "update-payment";
    }

    @PutMapping("/{id}")
    public String updatePayment(@PathVariable Long id, @ModelAttribute Payment payment) {
        paymentService.updatePayment(id, payment);
        return "redirect:/payments";
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}
