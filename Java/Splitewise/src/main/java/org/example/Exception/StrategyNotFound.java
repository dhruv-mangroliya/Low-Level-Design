package org.example.Exception;

public class StrategyNotFound extends RuntimeException {
    public StrategyNotFound(String message) {
        super(message + " strategy is not defined in Splitewise...");
    }
}
