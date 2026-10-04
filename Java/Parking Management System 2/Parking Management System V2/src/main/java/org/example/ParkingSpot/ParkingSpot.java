package org.example.ParkingSpot;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.VehicleSize;
import org.example.VehicleFactory.Vehicle;

@Getter
@Setter
public class ParkingSpot {
    private String spotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private VehicleSize vehicleSize;

    public ParkingSpot(String spotId, VehicleSize vehicleSize) {
        this.spotId = spotId;
        this.vehicleSize = vehicleSize;
        this.isAvailable = true;
    }
}
