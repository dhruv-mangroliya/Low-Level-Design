package org.example.Exceptions;

public class NoValidLongURL extends RuntimeException {
    public NoValidLongURL() {
        super("Unvalid Shortened URL.");
    }
}
