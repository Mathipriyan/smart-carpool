package com.carpool.smart_carpool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Enumerated(EnumType.STRING)
    private VehicleType type; // CAR, BIKE

    private int capacity;
    private String numberPlate;

    public enum VehicleType {
        CAR, BIKE
    }
}
