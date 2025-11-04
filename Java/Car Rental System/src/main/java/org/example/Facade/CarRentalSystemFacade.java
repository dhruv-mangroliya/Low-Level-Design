package org.example.Facade;

import org.example.CarRentalSystemBackend;
import org.example.Enums.VehicleType;
import org.example.Factories.ShopFactory;
import org.example.Factories.VehicleFactory;
import org.example.Models.Location;
import org.example.Models.Shop;
import org.example.Models.Vehicle;

public class CarRentalSystemFacade {
    public static void startCarRentalSystem(CarRentalSystemBackend carRentalSystemBackend){
        Shop shop1 = ShopFactory.createShop(1, "Shop1", new Location(395008, "Hirabaug"));
        Shop shop2 = ShopFactory.createShop(2, "Shop2", new Location(395009, "Mota Varachha"));
        Vehicle vehicle1 = VehicleFactory.createVehicle("Car", "GJ-05-AZ-001", 1000, VehicleType.CAR_FOUR_SEATER_COMPACT);
        Vehicle vehicle2 = VehicleFactory.createVehicle("Car", "GJ-06-FY-324", 2000, VehicleType.CAR_FOUR_SEATER_XUV);
        Vehicle vehicle3 = VehicleFactory.createVehicle("Car", "GJ-14-IZ-781", 10000, VehicleType.CAR_LUXURY);

        shop1.addVehicle(vehicle1);
        shop2.addVehicle(vehicle2);
        shop1.addVehicle(vehicle3);

        carRentalSystemBackend.addShop(shop1);
        carRentalSystemBackend.addShop(shop2);
        return;
    }
}
