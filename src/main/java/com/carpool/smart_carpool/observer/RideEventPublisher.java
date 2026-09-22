package com.carpool.smart_carpool.observer;

import com.carpool.smart_carpool.entity.Ride;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RideEventPublisher {

    private final List<RideObserver> observers = new ArrayList<>();

    public RideEventPublisher(List<RideObserver> observerList) {
        // Spring auto-injects all beans implementing RideObserver
        this.observers.addAll(observerList);
    }

    public void notifyObservers(Ride ride, String eventType) {
        for (RideObserver observer : observers) {
            observer.update(ride, eventType);
        }
    }
}
