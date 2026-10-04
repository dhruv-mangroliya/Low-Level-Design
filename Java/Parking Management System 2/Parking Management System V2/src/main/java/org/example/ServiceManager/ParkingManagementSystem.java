package org.example.ServiceManager;

import lombok.Getter;
import lombok.Setter;
import org.example.ParkingSpace.ParkingSpace;
import org.example.Payment.GooglePay;
import org.example.Payment.PaymentManager;
import org.example.Payment.UPI;
import org.example.PricingStrategy.PriceCostCalculatorManager;
import org.example.PricingStrategy.SizeBasedFees;
import org.example.Ticket.Ticket;
import org.example.VehicleFactory.Vehicle;

import java.time.Instant;
import java.util.UUID;

public class ParkingManagementSystem {
    private static volatile ParkingManagementSystem instance;
    private ParkingSpace parkingSpace;
    private PaymentManager paymentManager;
    private PriceCostCalculatorManager priceCostCalculatorManager;

    private ParkingManagementSystem() {
        this.parkingSpace = new ParkingSpace(3);
        this.paymentManager = new PaymentManager(new GooglePay());
        this.priceCostCalculatorManager = new PriceCostCalculatorManager(new SizeBasedFees());
    }

    public static ParkingManagementSystem getInstance(){
        if(instance == null){
            synchronized (ParkingManagementSystem.class) {
                if (instance == null)
                    instance = new ParkingManagementSystem();
            }
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle){
        Boolean parked = parkingSpace.parkVehicle(vehicle);
        if(parked){
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), Instant.now(), vehicle);
            return ticket;
        }
        return null;
    }

    public double unParkVehicle(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        Boolean unparked = parkingSpace.unparkVehicle(ticket);
        if(unparked){
            ticket.generateExitTime();
            double amount = priceCostCalculatorManager.calculatePrice(ticket.getDuration(), vehicle.getVehicleSize());
            paymentManager.processPayment(amount);
            System.out.println("Thanks for resiting.");
            return amount;
        }
        return 0;
    }
}
