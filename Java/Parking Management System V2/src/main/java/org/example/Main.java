package org.example;

import org.example.ServiceManager.ParkingManagementSystem;
import org.example.Ticket.Ticket;
import org.example.VehicleFactory.Vehicle;
import org.example.VehicleFactory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        Vehicle bike1 = VehicleFactory.createVehicleFactory("Bike","1");
        Vehicle car1 = VehicleFactory.createVehicleFactory("Car", "2");
        Vehicle bike2 = VehicleFactory.createVehicleFactory("Bike","3");
        Vehicle car2 = VehicleFactory.createVehicleFactory("Car", "4");
        Vehicle bike3 = VehicleFactory.createVehicleFactory("Bike","5");
        Vehicle car3 = VehicleFactory.createVehicleFactory("Car", "6");
        Vehicle bike4 = VehicleFactory.createVehicleFactory("Bike","7");
        Vehicle car4 = VehicleFactory.createVehicleFactory("Car", "8");

        ParkingManagementSystem parkingManagementSystem = ParkingManagementSystem.getInstance();
        Ticket ticket1  = parkingManagementSystem.parkVehicle(bike1);
        Ticket ticket2 = parkingManagementSystem.parkVehicle(bike2);
        Ticket ticket3  = parkingManagementSystem.parkVehicle(bike3);
        Ticket ticket4  = parkingManagementSystem.parkVehicle(bike4);
        parkingManagementSystem.unParkVehicle(ticket1);
        parkingManagementSystem.unParkVehicle(ticket2);
        parkingManagementSystem.unParkVehicle(ticket3);
    }
}