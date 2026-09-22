package com.carpool.smart_carpool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ride_requests")
@Data
public class RideRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "ride_id")
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private User rider;

    private int requestedSeats;

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    public enum RequestStatus {
        PENDING, ACCEPTED, REJECTED
    }
}
