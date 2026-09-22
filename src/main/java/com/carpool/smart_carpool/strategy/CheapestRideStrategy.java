package com.carpool.smart_carpool.strategy;

import com.carpool.smart_carpool.entity.Ride;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("cheapestRide")
public class CheapestRideStrategy implements RideMatchingStrategy {

    @Override
    public List<Ride> match(List<Ride> availableRides, String source, String destination) {
        return availableRides.stream()
                .filter(r -> r.getSource().equalsIgnoreCase(source)
                        && r.getDestination().equalsIgnoreCase(destination))
                .sorted(Comparator.comparingDouble(Ride::getCostPerSeat))
                .collect(Collectors.toList());
    }
}
