package com.example.carrental.controller;

import com.example.carrental.model.Customer;
import com.example.carrental.service.CustomerService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/profile")
    public String userProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Customer customer = customerService.findByEmail(userDetails.getUsername());
        model.addAttribute("customer", customer);
        return "profile";
    }
}
