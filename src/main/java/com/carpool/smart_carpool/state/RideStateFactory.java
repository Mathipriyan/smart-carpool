package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public class RideStateFactory {

    public static RideState getState(Ride.RideStatus status) {
        return switch (status) {
            case POSTED -> new PostedState();
            case CONFIRMED -> new ConfirmedState();
            case ONGOING -> new OngoingState();
            case COMPLETED -> new CompletedState();
            case CANCELLED -> new CancelledState();
        };
    }
}
