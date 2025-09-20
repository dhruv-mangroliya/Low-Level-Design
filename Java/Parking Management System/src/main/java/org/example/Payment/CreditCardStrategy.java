package org.example.Payment;

import java.util.HashMap;
import java.util.Map;

public class CreditCardStrategy extends PaymentMethod{

    @Override
    public void makePayment(String license, long amount) {
        System.out.println("Payment of " + amount + "$ received via Credit Card for license :" + license);
    }
}
