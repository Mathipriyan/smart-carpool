package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class CompletedState implements RideState {

    @Override
    public void confirm(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " already completed.");
    }

    @Override
    public void start(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " already completed.");
    }

    @Override
    public void complete(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " already completed.");
    }

    @Override
    public void cancel(Ride ride) {
        System.out.println("Cannot cancel ride #" + ride.getRideId() + " — already completed.");
    }
}
