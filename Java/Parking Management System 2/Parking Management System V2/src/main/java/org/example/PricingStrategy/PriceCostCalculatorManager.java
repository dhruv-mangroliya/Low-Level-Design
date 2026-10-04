package org.example.PricingStrategy;

public class PriceCostCalculatorManager {
    private PricingStrategy pricingStrategy;

    public PriceCostCalculatorManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculatePrice(long duration, org.example.Enums.VehicleSize vehicleSize) {
        return pricingStrategy.calculatePrice(duration, vehicleSize);
    }
}
