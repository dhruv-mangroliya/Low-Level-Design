package org.example.Payment;

import lombok.Getter;

public class GooglePay implements PaymentMethod{

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid using GooglePay : " + amount);
    }
}
