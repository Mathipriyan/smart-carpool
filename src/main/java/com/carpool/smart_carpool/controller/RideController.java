package com.carpool.smart_carpool.controller;

import com.carpool.smart_carpool.entity.Ride;
import com.carpool.smart_carpool.entity.User;
import com.carpool.smart_carpool.entity.Vehicle;
import com.carpool.smart_carpool.service.RideService;
import com.carpool.smart_carpool.service.RideMatchingService;
import com.carpool.smart_carpool.service.UserService;
import com.carpool.smart_carpool.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @Autowired
    private RideMatchingService rideMatchingService;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping
    public Ride postRide(@RequestBody RideRequestDto dto) {
        User driver = userService.getUserById(dto.getDriverId());
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        return rideService.postRide(driver, vehicle, dto.getSource(), dto.getDestination(),
                dto.getDepartureTime(), dto.getAvailableSeats(), dto.getCostPerSeat());
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public Ride getRide(@PathVariable Long id) {
        return rideService.getRideById(id);
    }

    // Strategy pattern in action — sortBy = earliest / cheapest / seats
    @GetMapping("/search")
    public List<Ride> searchRides(@RequestParam String source,
                                   @RequestParam String destination,
                                   @RequestParam(defaultValue = "earliest") String sortBy) {
        return rideMatchingService.findMatches(source, destination, sortBy);
    }

    // State pattern in action
    @PutMapping("/{id}/confirm")
    public Ride confirmRide(@PathVariable Long id) {
        return rideService.confirmRide(id);
    }

    @PutMapping("/{id}/start")
    public Ride startRide(@PathVariable Long id) {
        return rideService.startRide(id);
    }

    @PutMapping("/{id}/complete")
    public Ride completeRide(@PathVariable Long id) {
        return rideService.completeRide(id);
    }

    @PutMapping("/{id}/cancel")
    public Ride cancelRide(@PathVariable Long id) {
        return rideService.cancelRide(id);
    }

    public static class RideRequestDto {
        private Long driverId;
        private Long vehicleId;
        private String source;
        private String destination;
        private LocalDateTime departureTime;
        private int availableSeats;
        private double costPerSeat;

        public Long getDriverId() { return driverId; }
        public void setDriverId(Long driverId) { this.driverId = driverId; }
        public Long getVehicleId() { return vehicleId; }
        public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
        public String getSource() { return source; }
        public void setSource(String source) { this.source = source; }
        public String getDestination() { return destination; }
        public void setDestination(String destination) { this.destination = destination; }
        public LocalDateTime getDepartureTime() { return departureTime; }
        public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
        public int getAvailableSeats() { return availableSeats; }
        public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
        public double getCostPerSeat() { return costPerSeat; }
        public void setCostPerSeat(double costPerSeat) { this.costPerSeat = costPerSeat; }
    }
}
