package com.carpool.smart_carpool.service;

import com.carpool.smart_carpool.entity.Ride;
import com.carpool.smart_carpool.repository.RideRepository;
import com.carpool.smart_carpool.strategy.RideMatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideMatchingService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    @Qualifier("earliestDeparture")
    private RideMatchingStrategy earliestDepartureStrategy;

    @Autowired
    @Qualifier("cheapestRide")
    private RideMatchingStrategy cheapestRideStrategy;

    @Autowired
    @Qualifier("mostSeats")
    private RideMatchingStrategy mostSeatsStrategy;

    public List<Ride> findMatches(String source, String destination, String sortBy) {
        List<Ride> allRides = rideRepository.findAll();

        RideMatchingStrategy strategy = switch (sortBy.toLowerCase()) {
            case "cheapest" -> cheapestRideStrategy;
            case "seats" -> mostSeatsStrategy;
            default -> earliestDepartureStrategy; // default strategy
        };

        return strategy.match(allRides, source, destination);
    }
}
