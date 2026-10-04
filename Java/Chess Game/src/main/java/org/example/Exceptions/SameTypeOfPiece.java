package org.example.Exceptions;

public class SameTypeOfPiece extends RuntimeException {
    public SameTypeOfPiece() {
        super("Same type of piece found at destination cell.");
    }
}
