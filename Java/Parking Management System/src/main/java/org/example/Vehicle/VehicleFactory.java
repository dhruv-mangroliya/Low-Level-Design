package org.example.Vehicle;

public class VehicleFactory {
    public Vehicle createVehicle(String type, String license, VehicleSize size){
        if(type == "Bike"){
            return new Bike(license, size);
        }else{
            return new Car(license, size);
        }
    }
}
