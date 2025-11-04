package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.BookingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class Reservation {
    private Vehicle vehicle;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double paymentCost;
    private BookingStatus bookingStatus;

    public Reservation(Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate){
        this.vehicle = vehicle;
        this.endDate = endDate;
        this.startDate = startDate;
        this.bookingStatus = BookingStatus.CREATED;
        this.paymentCost = 0;
        System.out.println("Your Booking is initialised.");
    }

    public void printBooking(){
        System.out.println("________________Booking______________");
        System.out.println("Vehicle Plate Number: "+this.getVehicle().getPlateNumber());
        System.out.println("Booking Start Time: "+this.startDate.toString());
        System.out.println("Booking End Time: "+this.endDate.toString());
        System.out.println("Payment Cost :" + this.getPaymentCost());
        System.out.println("Booking Status :" + this.getBookingStatus().toString());
    }
}
