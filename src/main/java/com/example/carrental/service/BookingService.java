package com.example.carrental.service;

import com.example.carrental.model.Booking;
import com.example.carrental.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking createBooking(Booking booking) {
        long days = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
        booking.setTotalPrice(days * booking.getCar().getPricePerDay());
        return bookingRepository.save(booking);
    }
}
