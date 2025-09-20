package org.example.Parking;

import lombok.Getter;
import lombok.Setter;
import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class ParkingFloor {
    List<ParkingSpot> floorSpots = new ArrayList<>();
    int floorNumber;
    Map<String, ParkingSpot> spotMapping = new HashMap<>();

    public ParkingFloor(int index, int s, int m, int l){
        this.floorNumber = index;
        int ind = 1;
        for(int i=0;i<s;i++) floorSpots.add(new ParkingSpot(VehicleSize.SMALL, ind++));
        for(int i=0;i<m;i++) floorSpots.add(new ParkingSpot(VehicleSize.MEDIUM, ind++));
        for(int i=0;i<l;i++) floorSpots.add(new ParkingSpot(VehicleSize.LARGE, ind++));
    }

    public boolean isSpaceAvailable(VehicleSize size){
        for(ParkingSpot spot: floorSpots){
            if(spot.size == size && spot.vehicle == null){
                return true;
            }
        }
        return false;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: floorSpots){
            if(spot.getSize() == vehicle.getSize() && spot.vehicle == null){
                spot.setVehicle(vehicle);
                spotMapping.put(vehicle.getLicense(), spot);
                return spot;
            }
        }
        return null;
    }

    public void unparkVehicle(Vehicle vehicle){
        if(spotMapping.get(vehicle.getLicense()) != null){
            ParkingSpot spot = spotMapping.get(vehicle.getLicense());
            spotMapping.remove(vehicle.getLicense());
            spot.setVehicle(null);
            System.out.println("Vehicle unparked from Spot Number "+spot.spotNumber+" of floor :"+this.floorNumber);
            System.out.println();
        }
    }
}
