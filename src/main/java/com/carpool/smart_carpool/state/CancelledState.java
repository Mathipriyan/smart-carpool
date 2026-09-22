package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class CancelledState implements RideState {

    @Override
    public void confirm(Ride ride) {
        System.out.println("Cannot confirm ride #" + ride.getRideId() + " — it's cancelled.");
    }

    @Override
    public void start(Ride ride) {
        System.out.println("Cannot start ride #" + ride.getRideId() + " — it's cancelled.");
    }

    @Override
    public void complete(Ride ride) {
        System.out.println("Cannot complete ride #" + ride.getRideId() + " — it's cancelled.");
    }

    @Override
    public void cancel(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " is already cancelled.");
    }
}
