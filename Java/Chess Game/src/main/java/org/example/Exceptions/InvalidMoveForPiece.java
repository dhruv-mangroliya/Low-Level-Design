package org.example.Exceptions;

public class InvalidMoveForPiece extends RuntimeException {
    public InvalidMoveForPiece() {
        super("This is not a valid type of movement for selected piece.");
    }
}
