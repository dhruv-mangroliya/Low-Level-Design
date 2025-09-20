package org.example.Payment;

public abstract class PaymentMethod {
    public abstract void makePayment(String license, long amount);
}
