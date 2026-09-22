package com.carpool.smart_carpool.repository;

import com.carpool.smart_carpool.entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
    List<RideRequest> findByRide_RideId(Long rideId);
}
