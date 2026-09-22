package com.carpool.smart_carpool.observer;

import com.carpool.smart_carpool.entity.Ride;
import org.springframework.stereotype.Component;

@Component
public class RiderNotifier implements RideObserver {

    @Override
    public void update(Ride ride, String eventType) {
        System.out.println("[NOTIFY RIDERS] Ride #" + ride.getRideId() +
                " (" + ride.getSource() + " -> " + ride.getDestination() + ") event: " + eventType);
    }
}
