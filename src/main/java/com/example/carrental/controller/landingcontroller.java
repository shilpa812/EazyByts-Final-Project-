package com.example.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class landingcontroller {

    @GetMapping("/CRM")
    public String land() {
     return "landing";
    }
}

