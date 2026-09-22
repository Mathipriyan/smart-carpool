package com.carpool.smart_carpool.service;

import com.carpool.smart_carpool.entity.Ride;
import com.carpool.smart_carpool.entity.User;
import com.carpool.smart_carpool.entity.Vehicle;
import com.carpool.smart_carpool.factory.EntityFactory;
import com.carpool.smart_carpool.observer.RideEventPublisher;
import com.carpool.smart_carpool.repository.RideRepository;
import com.carpool.smart_carpool.state.RideState;
import com.carpool.smart_carpool.state.RideStateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private RideEventPublisher rideEventPublisher;

    // Post a new ride (uses Factory pattern)
    public Ride postRide(User driver, Vehicle vehicle, String source, String destination,
                          LocalDateTime departureTime, int availableSeats, double costPerSeat) {
        Ride ride = entityFactory.createRide(driver, vehicle, source, destination,
                departureTime, availableSeats, costPerSeat);
        Ride savedRide = rideRepository.save(ride);
        rideEventPublisher.notifyObservers(savedRide, "RIDE_POSTED");
        return savedRide;
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));
    }

    // Confirm a ride (uses State pattern)
    public Ride confirmRide(Long rideId) {
        Ride ride = getRideById(rideId);
        RideState state = RideStateFactory.getState(ride.getStatus());
        state.confirm(ride);
        Ride updated = rideRepository.save(ride);
        rideEventPublisher.notifyObservers(updated, "RIDE_CONFIRMED");
        return updated;
    }

    // Start a ride (uses State pattern)
    public Ride startRide(Long rideId) {
        Ride ride = getRideById(rideId);
        RideState state = RideStateFactory.getState(ride.getStatus());
        state.start(ride);
        Ride updated = rideRepository.save(ride);
        rideEventPublisher.notifyObservers(updated, "RIDE_STARTED");
        return updated;
    }

    // Complete a ride (uses State pattern)
    public Ride completeRide(Long rideId) {
        Ride ride = getRideById(rideId);
        RideState state = RideStateFactory.getState(ride.getStatus());
        state.complete(ride);
        Ride updated = rideRepository.save(ride);
        rideEventPublisher.notifyObservers(updated, "RIDE_COMPLETED");
        return updated;
    }

    // Cancel a ride (uses State pattern)
    public Ride cancelRide(Long rideId) {
        Ride ride = getRideById(rideId);
        RideState state = RideStateFactory.getState(ride.getStatus());
        state.cancel(ride);
        Ride updated = rideRepository.save(ride);
        rideEventPublisher.notifyObservers(updated, "RIDE_CANCELLED");
        return updated;
    }
}
