package com.example.airplane_mngt_system.controller;

import com.example.airplane_mngt_system.model.Flight;
import com.example.airplane_mngt_system.model.Ticket;
import com.example.airplane_mngt_system.service.TicketService;
import com.example.airplane_mngt_system.repository.FlightRepository;  // Added for flight lookup
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightRepository flightRepository;  // Add flight repository to fetch flight by ID

    @PostMapping("/book")
    public Ticket bookTicket(@RequestParam String passengerName,
                             @RequestParam String passengerEmail,
                             @RequestParam Long flightId) {
        // Look up the flight by its ID
        Flight flight = flightRepository.findById(flightId).orElse(null);

        if (flight == null) {
            throw new RuntimeException("Flight not found with ID: " + flightId);
        }

        return ticketService.bookTicket(passengerName, passengerEmail, flight);
    }
    @DeleteMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable Long ticketId) {
        boolean cancelled = ticketService.cancelTicket(ticketId);
        if (cancelled) {
            return "Ticket successfully cancelled";
        } else {
            return "Ticket not found";
        }
    }
}
