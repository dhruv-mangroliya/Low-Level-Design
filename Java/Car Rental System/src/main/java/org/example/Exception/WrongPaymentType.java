package org.example.Exception;

public class WrongPaymentType extends RuntimeException {
    public WrongPaymentType() {
        super("Wrong Payment Method Selected. Payment Failed.");
    }
}
