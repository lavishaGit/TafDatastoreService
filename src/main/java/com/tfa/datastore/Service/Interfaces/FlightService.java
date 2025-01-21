package com.tfa.datastore.Service.Interfaces;

import com.tfa.datastore.Models.Flights;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    public Flights addFlight(Flights flight);
    public List<Flights> getAllFlights();
    public Flights getFlightById(Long id);
    public Flights updateFlight(Long id, Flights updatedFlight);
    public void deleteFlight(Long id);

//
//    Flights addFlights(Flights flights);
//
//    List<Flights> getAllFlights();
//
//    Flights getFlightsById(Long id);
//
//    Flights updateFlights(Long id, Flights updatedFlights);
//
//    void deleteFlights(Long id);
}
