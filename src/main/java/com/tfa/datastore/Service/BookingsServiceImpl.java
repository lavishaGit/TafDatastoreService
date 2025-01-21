package com.tfa.datastore.Service;

import com.tfa.datastore.Models.*;
import com.tfa.datastore.Repositories.BookingsRepository;
import com.tfa.datastore.Repositories.FlightsRepository;
import com.tfa.datastore.Repositories.UsersRepository;
import com.tfa.datastore.Service.Interfaces.BookingService;
import com.tfa.datastore.Service.Interfaces.FlightService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.tfa.datastore.Models.Bookings.BookingStatus.CANCELLED;

@Service
public class BookingsServiceImpl implements BookingService {
    @Autowired
    private BookingsRepository bookingRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private FlightsRepository flightsRepository;

    @Transactional
@Override
    public BookingDTOResponse createBooking(BookingDTO bookingDTO) {
        Users user = usersRepository.findById(bookingDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found with id: " +bookingDTO.getUser_id()));
       Flights flights = flightsRepository.findById(bookingDTO.getFlight_id())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + bookingDTO.getFlight_id()));
        // Assume flightId is found in flight repository, and create Booking object
        Bookings booking = new Bookings();
        booking.setUser(user);
        // Set other fields like flight, status, createdAt, updatedAt, etc.
        booking.setFlight(flights); // Set your flight object accordingly
        booking.setStatus(Bookings.BookingStatus.valueOf(bookingDTO.getStatus()));
        Bookings savedBooking=  bookingRepository.save(booking);
        return new BookingDTOResponse(
                savedBooking.getId(),
                savedBooking.getUser().getId(),  // User ID
                savedBooking.getFlight().getId(), // Flight ID
                savedBooking.getStatus().toString(),
                savedBooking.getCreatedAt(),
                savedBooking.getUpdatedAt()
        );
    }
//    public Bookings createBooking(Bookings booking) {
//        Users user = usersRepository.findById(booking.getUser().getId())
//                .orElseThrow(() -> new RuntimeException("User not found with ID: "));
//
//        Flights flight = flightsRepository.findById(booking.getFlight().getId())
//                .orElseThrow(() -> new RuntimeException("Flight not found with ID: "));
//
//        // Create a new Bookings entity
//      //  Bookings booking = new Bookings();
//        booking.setUser(user);
//        booking.setFlight(flight);
//       // booking.setStatus(status);
///
//        return bookingRepository.save(booking);
//    }

    public BookingDTOResponse getBookingById(Long id) {
      Bookings  getBooking=  bookingRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Record not found"+id));
 return new BookingDTOResponse(
         getBooking.getId(),
         getBooking.getUser().getId(),  // User ID
         getBooking.getFlight().getId(), // Flight ID
         getBooking.getStatus().toString(),
         getBooking.getCreatedAt(),
         getBooking.getUpdatedAt()
        );
    }

    public List<BookingDTOResponse> getBookingsByUserId(Long userId) {
     Users user=   usersRepository.findById(userId).orElseThrow(()->new EntityNotFoundException("Record not found"+userId));
        List<Bookings> getBookings = bookingRepository.findByUserId(user.getId());

        // if (booking.getUser().equals(userId)){
        // Directly initialize a new list of BookingDTOResponse using a loop
        List<BookingDTOResponse> responses = new ArrayList<>();
        for (Bookings booking :getBookings) {
            responses.add(new BookingDTOResponse(
                    booking.getId(),                // Booking ID
                    booking.getUser().getId(),      // User ID
                    booking.getFlight().getId(),    // Flight ID
                    booking.getStatus().toString(), // Status
                    booking.getCreatedAt(),         // Created At
                    booking.getUpdatedAt()          // Updated At
            ));
//       }
//        return new EntityNotFoundException("userId not found"+userId);

        }
return  responses;
    }

    public BookingDTOResponse cancelBooking(Long id) {
        Bookings booking = bookingRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Record not found"+id));
     booking.setStatus(CANCELLED);
        Bookings getbooking=    bookingRepository.save(booking);
        return new BookingDTOResponse(
                getbooking.getId(),
                getbooking.getUser().getId(),  // User ID
                getbooking.getFlight().getId(), // Flight ID
                getbooking.getStatus().toString(),
                getbooking.getCreatedAt(),
                getbooking.getUpdatedAt()
        );
    }
}
