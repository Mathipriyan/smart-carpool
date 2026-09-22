package com.carpool.smart_carpool.strategy;

import com.carpool.smart_carpool.entity.Ride;
import java.util.List;

public interface RideMatchingStrategy {
    List<Ride> match(List<Ride> availableRides, String source, String destination);
}
