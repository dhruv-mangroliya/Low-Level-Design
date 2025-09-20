package org.example.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car extends Vehicle{
    Car(String license, VehicleSize size){
        super(license,size,"Car");
    }
}
