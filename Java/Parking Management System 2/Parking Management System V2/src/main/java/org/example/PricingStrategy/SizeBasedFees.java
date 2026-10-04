package org.example.PricingStrategy;

import org.example.Enums.VehicleSize;

public class SizeBasedFees implements PricingStrategy{

    @Override
    public double calculatePrice(long duration, VehicleSize vehicleSize) {
        if(vehicleSize == VehicleSize.SMALL){
            return duration * 10 + 100;
        }else if(vehicleSize == VehicleSize.MEDIUM){
            return duration * 20 + 200;
        }else{
            return duration * 30 + 300;
        }
    }
}
