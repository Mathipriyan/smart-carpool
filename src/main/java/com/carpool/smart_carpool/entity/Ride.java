package com.carpool.smart_carpool.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Data
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private int availableSeats;
    private double costPerSeat;

    @Enumerated(EnumType.STRING)
    private RideStatus status = RideStatus.POSTED;

    public enum RideStatus {
        POSTED, CONFIRMED, ONGOING, COMPLETED, CANCELLED
    }
}
