package org.example.ParkingSpace;

import org.example.ParkingFloor.ParkingFloor;
import org.example.ParkingSpot.ParkingSpot;
import org.example.Ticket.Ticket;
import org.example.VehicleFactory.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
    List<ParkingFloor> floors = new ArrayList<>();

    public ParkingSpace(int noOfFloors){
        for (int i = 0; i < noOfFloors; i++) {
            floors.add(new ParkingFloor(1, 1, i));
        }
    }

    public Boolean parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor : floors){
            ParkingSpot spot = floor.findVehicleSpace(vehicle.getVehicleSize());
            if(spot != null){
                floor.parkVehicle(spot, vehicle);
                System.out.println("Vehicle Parked at " + spot.getSpotId() + "on floor number " + floor.getFloorNumber());
                return true;
            }
        }
        System.out.println("Parking Not Available");
        return false;
    }

    public Boolean unparkVehicle(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        for(ParkingFloor floor : floors){
            for(ParkingSpot spot: floor.getParkingSpots()){
                if(spot.getVehicle() != null && spot.getVehicle().getVehicleNumber().equals(vehicle.getVehicleNumber())){
                    floor.unparkVehicle(spot);
                    System.out.println("Vehicle unparked from " + spot.getSpotId() + "on floor number " + floor.getFloorNumber());
                    return true;
                }
            }
        }
        System.out.println("Our space don't have your vehicle");
        return false;
    }
}
