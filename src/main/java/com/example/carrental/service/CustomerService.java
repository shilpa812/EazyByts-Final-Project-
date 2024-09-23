package com.example.carrental.service;

import com.example.carrental.model.Customer;
import com.example.carrental.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
  //  private final BCryptPasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    //    this.passwordEncoder = passwordEncoder;
    }

    public Customer registerCustomer(Customer customer) {
     //   customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
