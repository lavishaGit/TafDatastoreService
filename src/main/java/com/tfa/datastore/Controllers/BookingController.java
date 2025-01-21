package com.tfa.datastore.Controllers;

import com.tfa.datastore.Models.BookingDTO;
import com.tfa.datastore.Models.BookingDTOResponse;
import com.tfa.datastore.Models.Bookings;
import com.tfa.datastore.Repositories.BookingsRepository;
import com.tfa.datastore.Service.BookingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datastore/bookings")
public class BookingController {
    @Autowired
    private BookingsServiceImpl bookingsServiceImpl;

    @PostMapping
    public ResponseEntity<BookingDTOResponse> createBooking(@RequestBody BookingDTO booking) {
        return ResponseEntity.ok( bookingsServiceImpl.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTOResponse> getBooking(@PathVariable Long id) {
    BookingDTOResponse booking=   bookingsServiceImpl.getBookingById(id);
               return ResponseEntity.ok(booking);

    }

    @GetMapping("/users/{UserId}")
    public ResponseEntity<List<BookingDTOResponse>> getBookingsByUser(@PathVariable Long UserId) {
        return ResponseEntity.ok(bookingsServiceImpl.getBookingsByUserId(UserId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDTOResponse> cancelBooking(@PathVariable Long id) {
        BookingDTOResponse booking=   bookingsServiceImpl.cancelBooking(id);
        return ResponseEntity.ok(booking);
    }
}

