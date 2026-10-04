package org.example.Models;

import org.example.Enums.VehicleType;

public class Car extends Vehicle{
    public Car(String plateNumber, double perDayRent, VehicleType vehicleType){
        super(plateNumber, perDayRent, vehicleType);
    }
}
