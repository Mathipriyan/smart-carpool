package com.carpool.smart_carpool.controller;

import com.carpool.smart_carpool.entity.Vehicle;
import com.carpool.smart_carpool.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public Vehicle addVehicle(@RequestBody VehicleRequest request) {
        return vehicleService.addVehicle(request.getOwnerId(), request.getType(),
                request.getCapacity(), request.getNumberPlate());
    }

    public static class VehicleRequest {
        private Long ownerId;
        private Vehicle.VehicleType type;
        private int capacity;
        private String numberPlate;

        public Long getOwnerId() { return ownerId; }
        public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
        public Vehicle.VehicleType getType() { return type; }
        public void setType(Vehicle.VehicleType type) { this.type = type; }
        public int getCapacity() { return capacity; }
        public void setCapacity(int capacity) { this.capacity = capacity; }
        public String getNumberPlate() { return numberPlate; }
        public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }
    }
}
