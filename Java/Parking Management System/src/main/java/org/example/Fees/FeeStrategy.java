package org.example.Fees;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleFactory;
import org.example.Vehicle.VehicleSize;

public interface FeeStrategy {
    public long calculateCharges(Vehicle vehicle);
}
