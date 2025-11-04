package org.example.Factories;

import org.example.Enums.CarType;
import org.example.Models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String plateNumber, double perDayRent, CarType carType){
        return new Vehicle(plateNumber, perDayRent, carType);
    }
}
