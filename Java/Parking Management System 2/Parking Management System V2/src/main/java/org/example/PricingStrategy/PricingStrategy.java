package org.example.PricingStrategy;

import org.example.Enums.VehicleSize;

public interface PricingStrategy {
    double calculatePrice(long duration, VehicleSize vehicleSize);
}
