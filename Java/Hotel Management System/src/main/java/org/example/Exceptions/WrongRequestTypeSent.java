package org.example.Exceptions;

public class WrongRequestTypeSent extends RuntimeException {
    public WrongRequestTypeSent() {
        super("Wrong Type of Search Request sent.");
    }
}
