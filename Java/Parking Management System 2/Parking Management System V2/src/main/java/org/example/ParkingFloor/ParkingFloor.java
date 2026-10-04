package org.example.ParkingFloor;

import lombok.Getter;
import org.example.Enums.VehicleSize;
import org.example.ParkingSpot.ParkingSpot;
import org.example.VehicleFactory.Vehicle;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingFloor {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    Integer floorNumber;

    public ParkingFloor(Integer noOfBikeSpot, Integer noOfCarSpot, Integer id){
        for (int i = 0; i < noOfBikeSpot; i++) {
            parkingSpots.add(new ParkingSpot("BIKE" + i, VehicleSize.SMALL));
        }
        for (int i = 0; i < noOfCarSpot; i++) {
            parkingSpots.add(new ParkingSpot("CAR" + i, VehicleSize.MEDIUM));
        }
        this.floorNumber = id;
    }

    public ParkingSpot findVehicleSpace(VehicleSize vehicleSize) {
        for (ParkingSpot spot : parkingSpots){
            if (spot.isAvailable() && spot.getVehicleSize().equals(vehicleSize)) {
                return spot;
            }
        }
        return null;
    }

    public void parkVehicle(ParkingSpot location, Vehicle vehicle){
        location.setVehicle(vehicle);
        location.setAvailable(false);
        return;
    }

    public void unparkVehicle(ParkingSpot targetLoction){
        targetLoction.setVehicle(null);
        targetLoction.setAvailable(true);
        return;
    }
}
