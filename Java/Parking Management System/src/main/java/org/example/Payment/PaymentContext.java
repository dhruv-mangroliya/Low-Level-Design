package org.example.Payment;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class PaymentContext {
    PaymentMethod method;

    public void makePayment(String license, long amount) {
        method.makePayment(license, amount);
    }


}
