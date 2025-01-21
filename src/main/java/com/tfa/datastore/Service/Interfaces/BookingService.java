package com.tfa.datastore.Service.Interfaces;

import com.tfa.datastore.Models.BookingDTO;
import com.tfa.datastore.Models.BookingDTOResponse;
import com.tfa.datastore.Models.Bookings;

import java.util.List;

public interface BookingService {
 public BookingDTOResponse createBooking(BookingDTO booking);
    public BookingDTOResponse getBookingById(Long id);
    public List<BookingDTOResponse> getBookingsByUserId(Long userId);
    public BookingDTOResponse cancelBooking(Long id);
   // public Bookings createBooking(Long userId, Long flightId, String status);
}
