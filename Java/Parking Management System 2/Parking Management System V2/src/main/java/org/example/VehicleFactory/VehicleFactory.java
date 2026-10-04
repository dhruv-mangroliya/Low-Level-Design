package org.example.VehicleFactory;

import org.example.Enums.VehicleSize;

public class VehicleFactory {
    public static Vehicle createVehicleFactory (String vehicleType, String plateNumber){
        if(vehicleType.equals("Bike")){
            return new Bike(plateNumber);
        }
        if(vehicleType.equals("Car")){
            return new Car(plateNumber);
        }
        return null;
    }
}
