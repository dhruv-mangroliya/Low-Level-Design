package org.example.Vehicle;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Bike extends Vehicle{
    Bike(String license, VehicleSize size){
        super(license,size,"Bike");
    }
}
