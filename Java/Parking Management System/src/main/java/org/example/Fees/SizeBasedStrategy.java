package org.example.Fees;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleSize;

public class SizeBasedStrategy implements FeeStrategy{
    @Override
    public long calculateCharges(Vehicle vehicle) {
        if(vehicle.getSize() == VehicleSize.LARGE) return 100;
        if(vehicle.getSize() == VehicleSize.MEDIUM) return 50;
        if(vehicle.getSize() == VehicleSize.SMALL) return 25;
        return 0;
    }
}
