package org.example.Fees;

import org.example.Vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class FeesManager {
    static Map<String, FeeStrategy> feeMapping  = new HashMap<>();;

    public static void addFeeStrategy(FeeStrategy feeStrategy, String license) {
        feeMapping.put(license, feeStrategy);
        System.out.println("License "+license +" choosed " + ((feeStrategy instanceof FlatRateStrategy) ? "Flat Rate" : "Size Rate"));
        System.out.println();
    }

    public static FeeStrategy getFeeStrategy(String license){
        return feeMapping.get(license);
    }

    public static long calculateMyFees(Vehicle vehicle){
        FeeStrategy feeStrategy = getFeeStrategy(vehicle.getLicense());
        return feeStrategy.calculateCharges(vehicle);
    }
}
