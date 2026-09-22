package com.carpool.smart_carpool.repository;

import com.carpool.smart_carpool.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
