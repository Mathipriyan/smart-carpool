package com.carpool.smart_carpool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role; // DRIVER, RIDER, BOTH

    private Double rating = 5.0;

    public enum Role {
        DRIVER, RIDER, BOTH
    }
}
