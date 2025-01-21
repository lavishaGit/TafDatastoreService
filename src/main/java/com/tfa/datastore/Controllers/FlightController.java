package com.tfa.datastore.Controllers;

import com.tfa.datastore.Models.Flights;
import com.tfa.datastore.Repositories.FlightsRepository;
import com.tfa.datastore.Service.FlightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datastore/flights")
public class FlightController {
    @Autowired
    private FlightsServiceImpl flightsServiceImpl;

    @PostMapping
    public ResponseEntity<Flights> createFlight(@RequestBody Flights flight) {
        return ResponseEntity.ok(flightsServiceImpl.addFlight(flight));
    }
    @GetMapping
    public ResponseEntity<List<Flights>> getFlights() {
        List<Flights> flight= flightsServiceImpl.getAllFlights();
        return ResponseEntity.ok(flight);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flights> getFlight(@PathVariable Long id) {
     Flights flight= flightsServiceImpl.getFlightById(id);
       return ResponseEntity.ok(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flights> updateFlight(@PathVariable Long id, @RequestBody Flights flight) {
      Flights updatedflight=  flightsServiceImpl.updateFlight(id, flight);

        return ResponseEntity.ok(updatedflight);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        flightsServiceImpl.deleteFlight(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Flight record successfulyy deleted");
    }

}
