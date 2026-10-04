package org.example.Exceptions;

public class PieceNotFound extends Exception{
    public PieceNotFound(){
        super("No piece found at this cell location.");
    }
}
