package org.example;

import lombok.SneakyThrows;
import org.example.Fees.FeesManager;
import org.example.Fees.FlatRateStrategy;
import org.example.Fees.SizeBasedStrategy;
import org.example.Parking.ParkingFloor;
import org.example.Parking.ParkingSpace;
import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleFactory;
import org.example.Vehicle.VehicleSize;

public class ParkingManagementDemo {
    @SneakyThrows
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        ParkingSpace parking = ParkingSpace.getInstance();
        parking.createParkingSpace(2,1,1,1);

        Vehicle v1 = vehicleFactory.createVehicle("Bike", "Bike1", VehicleSize.SMALL);

        Vehicle v2 = vehicleFactory.createVehicle("Bike", "Bike2", VehicleSize.SMALL);

        Vehicle v3 = vehicleFactory.createVehicle("Car", "Car1", VehicleSize.MEDIUM);

        Vehicle v4 = vehicleFactory.createVehicle("Car", "Car2", VehicleSize.MEDIUM);

        Vehicle v5 = vehicleFactory.createVehicle("Bike", "Bike3", VehicleSize.SMALL);


        System.out.println(v1);
        ParkingFloor f1 = parking.parkVehicle(v1);
        if(f1 != null) parking.feeStrategyChoosed(v1, new FlatRateStrategy());

        ParkingFloor f2 = parking.parkVehicle(v2);
        if(f2 != null) parking.feeStrategyChoosed(v2, new SizeBasedStrategy());

        ParkingFloor f3 = parking.parkVehicle(v3);
        if(f3 != null) parking.feeStrategyChoosed(v3, new FlatRateStrategy());

        ParkingFloor f4 = parking.parkVehicle(v4);
        if(f4 != null) parking.feeStrategyChoosed(v4, new SizeBasedStrategy());

        ParkingFloor f5 = parking.parkVehicle(v4);
        if(f5 != null) parking.feeStrategyChoosed(v4, new SizeBasedStrategy());

        Thread.sleep(10_000);

        long changes1 = FeesManager.calculateMyFees(v1);
        parking.makePayment(v1, changes1);
        parking.unparkVehicle(v1);

        long changes2 = FeesManager.calculateMyFees(v4);
        parking.makePayment(v4, changes2);
        parking.unparkVehicle(v4);

        parking.parkVehicle(v5);



    }
}
