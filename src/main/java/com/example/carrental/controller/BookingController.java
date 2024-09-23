package com.example.carrental.controller;

import com.example.carrental.model.Booking;
import com.example.carrental.service.BookingService;
import com.example.carrental.service.CarService;
import com.example.carrental.service.CustomerService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final CarService carService;
    private final CustomerService customerService;

    public BookingController(BookingService bookingService, CarService carService,CustomerService customerService) {
        this.bookingService = bookingService;
        this.carService = carService;
		this.customerService = customerService;
    }

    @GetMapping("/create/{carId}")
    public String showBookingForm(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute Booking booking, @AuthenticationPrincipal UserDetails userDetails) {
        booking.setUserId(customerService.findByEmail(userDetails.getUsername()).getCustomerId());
        bookingService.createBooking(booking);
        return "redirect:/profile";
    }

    @GetMapping
    public String listUserBookings(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Long userId = customerService.findByEmail(userDetails.getUsername()).getCustomerId();
        List<Booking> bookings = bookingService.getUserBookings(userId);
        model.addAttribute("bookings", bookings);
        return "booking-list";
    }
}
