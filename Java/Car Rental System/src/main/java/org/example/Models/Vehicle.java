package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.VehicleType;

@Getter
@Setter
public abstract class Vehicle {
    private String plateNumber;
    private double perDayRent;
    private VehicleType vehicleType;

    public Vehicle(String plateNumber, double perDayRent, VehicleType vehicleType){
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
        this.perDayRent = perDayRent;
    }
}
