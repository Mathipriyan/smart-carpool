package com.carpool.smart_carpool.service;

import com.carpool.smart_carpool.entity.Vehicle;
import com.carpool.smart_carpool.entity.User;
import com.carpool.smart_carpool.factory.EntityFactory;
import com.carpool.smart_carpool.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private UserService userService;

    public Vehicle addVehicle(Long ownerId, Vehicle.VehicleType type, int capacity, String numberPlate) {
        User owner = userService.getUserById(ownerId);
        Vehicle vehicle = entityFactory.createVehicle(owner, type, capacity, numberPlate);
        return vehicleRepository.save(vehicle);
    }
}
