package com.carpool.smart_carpool.observer;

import com.carpool.smart_carpool.entity.Ride;
import org.springframework.stereotype.Component;

@Component
public class DriverNotifier implements RideObserver {

    @Override
    public void update(Ride ride, String eventType) {
        System.out.println("[NOTIFY DRIVER] " + ride.getDriver().getName() +
                " - Ride #" + ride.getRideId() + " event: " + eventType);
    }
}
