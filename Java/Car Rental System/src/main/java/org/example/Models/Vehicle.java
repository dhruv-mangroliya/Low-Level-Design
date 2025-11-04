package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.CarType;
import org.example.Factories.VehicleFactory;

@Getter
@Setter
public class Vehicle {
    private String plateNumber;
    private double perDayRent;
    private CarType carType;

    public Vehicle(String plateNumber, double perDayRent, CarType carType){
        this.carType = carType;
        this.plateNumber = plateNumber;
        this.perDayRent = perDayRent;
    }
}
