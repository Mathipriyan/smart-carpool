package com.carpool.smart_carpool.observer;

import com.carpool.smart_carpool.entity.Ride;

public interface RideObserver {
    void update(Ride ride, String eventType);
}
