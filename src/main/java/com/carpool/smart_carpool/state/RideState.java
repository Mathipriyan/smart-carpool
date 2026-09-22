package com.carpool.smart_carpool.state;

import com.carpool.smart_carpool.entity.Ride;

public interface RideState {
    void confirm(Ride ride);
    void start(Ride ride);
    void complete(Ride ride);
    void cancel(Ride ride);
}
