package com.tfa.datastore.Service;

import com.tfa.datastore.Models.Flights;
import com.tfa.datastore.Repositories.FlightsRepository;
import com.tfa.datastore.Service.Interfaces.FlightService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsServiceImpl implements FlightService {
    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public Flights addFlight(Flights flight) {
        return flightsRepository.save(flight);
    }

    @Override
    public List<Flights> getAllFlights() {
        return flightsRepository.findAll();
    }

    @Override
    public Flights getFlightById(Long id) {
        return   flightsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with ID: " + id));
    }

    @Override
    public Flights updateFlight(Long id, Flights updatedFlights) {
        Flights flights = flightsRepository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Flight not found with ID: " + id));
        flights.setFlightNumber(updatedFlights.getFlightNumber());
        flights.setArrival(updatedFlights.getArrival());
        flights.setDeparture(updatedFlights.getDeparture());
        flights.setDepartureTime(updatedFlights.getDepartureTime());
        flights.setArrivalTime(updatedFlights.getArrivalTime());
        flights.setAvailableSeats(updatedFlights.getAvailableSeats());
        return flightsRepository.save(flights);
    }

    @Override
    public void deleteFlight(Long id) {

        flightsRepository.deleteById(id);
    }



}
