package org.example.VehicleFactory;

import org.example.Enums.VehicleSize;

public class Car implements Vehicle{
    private VehicleSize vehiclesize;
    private String plateNumber;
    public Car(String number){
        this.plateNumber = number;
        this.vehiclesize = VehicleSize.MEDIUM;
    }

    @Override
    public VehicleSize getVehicleSize(){
        return this.vehiclesize;
    }

    @Override
    public String getVehicleNumber(){
        return this.plateNumber;
    }
}
