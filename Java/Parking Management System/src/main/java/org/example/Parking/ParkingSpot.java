package org.example.Parking;

import lombok.Getter;
import lombok.Setter;
import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleSize;

@Setter @Getter
public class ParkingSpot {
    VehicleSize size;
    Vehicle vehicle;
    int spotNumber;

    public ParkingSpot(VehicleSize s, int index){
        this.size = s;
        this.vehicle = null;
        this.spotNumber = index;
    }
}
