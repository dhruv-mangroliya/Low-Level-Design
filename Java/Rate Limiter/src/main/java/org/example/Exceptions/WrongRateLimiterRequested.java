package org.example.Exceptions;

public class WrongRateLimiterRequested extends RuntimeException {
    public WrongRateLimiterRequested() {
        super("Wrong Type of Rate Limiter Request.");
    }
}
