package org.example.Payment;

import lombok.Getter;

public class UPI implements PaymentMethod{

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid using UPI : " + amount);
    }
}
