package org.example.Factories;

import org.example.Enums.VehicleType;
import org.example.Models.Car;
import org.example.Models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String plateNumber, double perDayRent, VehicleType vehicleType){
        if(type == "Car")
            return new Car(plateNumber, perDayRent, vehicleType);
        return null;
    }
}
