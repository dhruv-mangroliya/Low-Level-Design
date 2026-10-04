package org.example.Exceptions;

public class IllegalPieceChoosen extends RuntimeException {
    public IllegalPieceChoosen() {
        super("Choose piece with correct colour.");
    }
}
