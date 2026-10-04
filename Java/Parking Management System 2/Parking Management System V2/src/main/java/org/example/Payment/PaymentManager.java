package org.example.Payment;

public class PaymentManager {
    private PaymentMethod  paymentMethod;

    public PaymentManager(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount){
        paymentMethod.processPayment(amount);
    }
}
