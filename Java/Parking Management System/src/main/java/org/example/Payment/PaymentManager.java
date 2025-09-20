package org.example.Payment;

import org.example.Vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentManager {
    public Map<String, Boolean> paymentBook = new HashMap<>();
    private static volatile PaymentManager instance;

    public static synchronized PaymentManager getInstance(){
        if(instance == null){
            instance = new PaymentManager();
        }
        return instance;
    }

    public void makePayment(Vehicle vehicle, long amount){
        PaymentContext context = new PaymentContext();
        if(paymentBook.get(vehicle.getLicense()) != null){
            System.out.println("No payment required.");
            return;
        }
        System.out.println("Choose Payment Method: ");
        System.out.println("1. UPI    2. Credit Card");
        Scanner sc = new Scanner(System.in);
        int paymentType = sc.nextInt();

        if(paymentType == 1){
            context.setMethod(new UPIStrategy());
        }else{
            context.setMethod(new CreditCardStrategy());
        }
        paymentBook.put(vehicle.getLicense(), true);
        System.out.println(vehicle.getLicense()+" Paid");
        context.makePayment(vehicle.getLicense(), amount);
//        System.out.println(isPaymentRequired(vehicle.getLicense()));
    }

    public boolean isPaymentRequired(String license) {
        if(paymentBook.get(license) == null) return true;
        return false;
    }

    public void removeOldPayment(String license){
        paymentBook.remove(license);
    }
}
