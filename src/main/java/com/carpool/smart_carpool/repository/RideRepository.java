package com.carpool.smart_carpool.repository;

import com.carpool.smart_carpool.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findBySourceAndDestination(String source, String destination);
}
