package org.example.Fees;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleSize;

import java.time.Instant;

public class FlatRateStrategy implements FeeStrategy{
    @Override
    public long calculateCharges(Vehicle vehicle) {
        long second = Instant.now().getEpochSecond() - vehicle.getEntryTimeSecond();
        if(vehicle.getSize() == VehicleSize.LARGE) return second*10;
        if(vehicle.getSize() == VehicleSize.MEDIUM) return second*5;
        if(vehicle.getSize() == VehicleSize.SMALL) return second*3;
        return 0;
    }
}
