package org.example.Exception;

public class WrongSplitStrategyProvided extends RuntimeException {
    public WrongSplitStrategyProvided() {
        super("Wrong Split Strategy Provided. It's either EQUAL or PERCENTAGE");
    }
}
