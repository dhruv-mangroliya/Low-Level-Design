package org.example.Parking;

import org.example.Fees.FeeStrategy;
import org.example.Fees.FeesManager;
import org.example.Payment.*;
import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleSize;

import java.util.*;

public class ParkingSpace {
    private final List<ParkingFloor> floors = new ArrayList<>();
    private static ParkingSpace instance;
    private final Map<Vehicle, ParkingFloor> floorMapping = new HashMap<>();

    public static synchronized ParkingSpace getInstance(){
        if(instance == null){
            instance = new ParkingSpace();
        }
        return instance;
    }

    public void createParkingSpace(int floor, int small, int medium, int large){
        for(int i=0;i<floor; i++){
            floors.add(new ParkingFloor(i, small, medium, large));
        }
    }

    public void feeStrategyChoosed(Vehicle v, FeeStrategy feeStrategy){
        FeesManager.addFeeStrategy(feeStrategy, v.getLicense());
    }

    public ParkingFloor parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            if(floor.isSpaceAvailable(vehicle.getSize())){
                ParkingSpot spot = floor.parkVehicle(vehicle);

                floorMapping.put(vehicle, floor);
                System.out.println("Vehicle with license : " + vehicle.getLicense() + " Parked at spot number: " + spot.getSpotNumber() + " of "+floor.floorNumber+"th floor.");
                return floor;
            }
        }
        System.out.println("Sorry, No space available as per your requirement.");
        return null;
    }

    public void unparkVehicle(Vehicle vehicle){
        if(floorMapping.get(vehicle) == null){
            System.out.println("We don't have your vehicle with license " + vehicle.getLicense());
            return;
        }
        PaymentManager paymentManager = PaymentManager.getInstance();

        if(paymentManager.isPaymentRequired(vehicle.getLicense())){
            System.out.println("First pay then come to take your vehicle.");
            return;
        }

        ParkingFloor parkedFloor = floorMapping.get(vehicle);
        parkedFloor.unparkVehicle(vehicle);
        floorMapping.remove(vehicle);
        paymentManager.removeOldPayment(vehicle.getLicense());

        return;
    }

    public void makePayment(Vehicle vehicle, long amount){
        PaymentManager paymentManager = PaymentManager.getInstance();
        paymentManager.makePayment(vehicle, amount);
    }


}
