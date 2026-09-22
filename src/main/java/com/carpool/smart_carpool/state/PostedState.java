package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class PostedState implements RideState {

    @Override
    public void confirm(Ride ride) {
        ride.setStatus(Ride.RideStatus.CONFIRMED);
        System.out.println("Ride #" + ride.getRideId() + " confirmed.");
    }

    @Override
    public void start(Ride ride) {
        System.out.println("Cannot start ride #" + ride.getRideId() + " — not confirmed yet.");
    }

    @Override
    public void complete(Ride ride) {
        System.out.println("Cannot complete ride #" + ride.getRideId() + " — ride hasn't started.");
    }

    @Override
    public void cancel(Ride ride) {
        ride.setStatus(Ride.RideStatus.CANCELLED);
        System.out.println("Ride #" + ride.getRideId() + " cancelled.");
    }
}
