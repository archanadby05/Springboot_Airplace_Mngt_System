package com.example.airplane_mngt_system.repository;

import com.example.airplane_mngt_system.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Additional query methods can be added here if needed.
}
