package com.example.airplane_mngt_system.controller;

import com.example.airplane_mngt_system.model.Flight;
import com.example.airplane_mngt_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Schedule a new flight
    @PostMapping
    public ResponseEntity<Flight> scheduleFlight(@RequestBody Flight flight) {
        Flight scheduledFlight = flightService.scheduleFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledFlight);
    }

    // Get all scheduled flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
}
