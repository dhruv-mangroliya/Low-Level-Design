package org.example.VehicleFactory;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.VehicleSize;

public class Bike implements Vehicle{
    private VehicleSize vehiclesize;
    private String plateNumber;
    public Bike(String number){
        this.plateNumber = number;
        this.vehiclesize = VehicleSize.SMALL;
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
