package org.example.Services;

import org.example.Enums.BookingStatus;
import org.example.Exception.WrongPaymentType;
import org.example.Models.Reservation;

import java.util.Scanner;

public class PaymentGateway {
    public boolean capturePayment(Reservation reservation){
        double amt = reservation.getPaymentCost();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to SBI Bank Payment Gateway.");
        System.out.println("Press 1 for Credit Card.");
        System.out.println("Press 2 for Debit Card.");
        System.out.println("Press 3 for UPI.");

        int type = sc.nextInt();

        if(type == 1){
            System.out.println("Payment Successful. Mode: Credit Card. Amount: "+amt);
        }else if(type == 2){
            System.out.println("Payment Successful. Mode: Debit Card. Amount: "+amt);
        }else if(type == 3){
            System.out.println("Payment Successful. Mode: UPI. Amount: "+amt);
        }else{
            throw new WrongPaymentType();
        }
        reservation.setBookingStatus(BookingStatus.CONFIRMED);
        System.out.println("Reservation Completed.");
        return true;
    }
}
