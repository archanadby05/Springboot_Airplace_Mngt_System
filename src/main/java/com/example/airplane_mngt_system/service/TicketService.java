package com.example.airplane_mngt_system.service;

import com.example.airplane_mngt_system.model.Flight;
import com.example.airplane_mngt_system.model.Ticket;
import com.example.airplane_mngt_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket bookTicket(String passengerName, String passengerEmail, Flight flight) {
        Ticket ticket = new Ticket(passengerName, passengerEmail, LocalDateTime.now(), flight);
        return ticketRepository.save(ticket);
    }
}
