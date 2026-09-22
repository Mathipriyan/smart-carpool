package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class OngoingState implements RideState {

    @Override
    public void confirm(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " is already ongoing.");
    }

    @Override
    public void start(Ride ride) {
        System.out.println("Ride #" + ride.getRideId() + " is already ongoing.");
    }

    @Override
    public void complete(Ride ride) {
        ride.setStatus(Ride.RideStatus.COMPLETED);
        System.out.println("Ride #" + ride.getRideId() + " completed.");
    }

    @Override
    public void cancel(Ride ride) {
        System.out.println("Cannot cancel ride #" + ride.getRideId() + " — ride already ongoing.");
    }
}
