package org.example.Models;

import org.example.Enums.BookingStatus;
import org.example.Services.PaymentGateway;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationManager {
    private static ReservationManager instance;
    private Map<String, List<Reservation>> vehicleBookings = new HashMap<>();

    public static synchronized ReservationManager getReservationManager(){
        if(instance == null){
            instance = new ReservationManager();
        }
        return instance;
    }

    public boolean isAvailable(Vehicle vehicle, LocalDateTime startDate, LocalDateTime endTime){
        List<Reservation> reservationList = this.vehicleBookings.get(vehicle.getPlateNumber());
        if(reservationList == null) return true;

        for (Reservation r : reservationList) {
            LocalDateTime bookedStart = r.getStartDate();
            LocalDateTime bookedEnd = r.getEndDate();

            if (startDate.isBefore(bookedEnd) && bookedStart.isBefore(endTime)) {
                System.out.println();
                System.out.println("___________________________________________________________________");
                System.out.println("Sorry, Vehicle is booked for this time frame. Pick some other car.");
                System.out.println("___________________________________________________________________");
                System.out.println();
                return false;
            }
        }

        return true;
    }

    public Reservation createReservation(Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate){
        Reservation reservation = new Reservation(vehicle, startDate, endDate);
        reservation.setBookingStatus(BookingStatus.PROCESSING);
        System.out.println("Your Booking is processing.");

        reservation.setPaymentCost(instance.calculateRent(reservation));
        System.out.println("Your rent cost will be: "+reservation.getPaymentCost());

        reservation.setBookingStatus(BookingStatus.PAYMENT);
        System.out.println("Booking is in payment phase now.");

        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.capturePayment(reservation);

        List<Reservation> list = vehicleBookings.get(vehicle.getPlateNumber());
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(reservation);
        vehicleBookings.put(vehicle.getPlateNumber(), list);

        return reservation;
    }
    public double calculateRent(Reservation reservation){
        double hours = ChronoUnit.HOURS.between(reservation.getStartDate(), reservation.getEndDate());
        double days = hours / 24.0;
        return days*reservation.getVehicle().getPerDayRent();
    }
}
