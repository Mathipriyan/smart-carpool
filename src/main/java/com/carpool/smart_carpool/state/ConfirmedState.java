package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class ConfirmedState implements RideState {

    @Override
    public void confirm(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " is already confirmed.");
    }

    @Override
    public void start(Ride ride) {
        ride.setStatus(Ride.RideStatus.ONGOING);
        System.out.println("Ride #" + ride.getRideId() + " started.");
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
