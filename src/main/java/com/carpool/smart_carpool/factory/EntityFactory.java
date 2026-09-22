package com.carpool.smart_carpool.factory;

import com.carpool.smart_carpool.entity.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class EntityFactory {

    // Factory method to create a User
    public User createUser(String name, String email, String phone, User.Role role) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        user.setRating(5.0); // default starting rating
        return user;
    }

    // Factory method to create a Vehicle
    public Vehicle createVehicle(User owner, Vehicle.VehicleType type, int capacity, String numberPlate) {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(owner);
        vehicle.setType(type);
        vehicle.setCapacity(capacity);
        vehicle.setNumberPlate(numberPlate);
        return vehicle;
    }

    // Factory method to create a Ride
    public Ride createRide(User driver, Vehicle vehicle, String source, String destination,
                            LocalDateTime departureTime, int availableSeats, double costPerSeat) {
        Ride ride = new Ride();
        ride.setDriver(driver);
        ride.setVehicle(vehicle);
        ride.setSource(source);
        ride.setDestination(destination);
        ride.setDepartureTime(departureTime);
        ride.setAvailableSeats(availableSeats);
        ride.setCostPerSeat(costPerSeat);
        ride.setStatus(Ride.RideStatus.POSTED);
        return ride;
    }
}
