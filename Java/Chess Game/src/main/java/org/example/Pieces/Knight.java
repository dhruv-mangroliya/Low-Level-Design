package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;

public class Knight extends Piece{
    public Knight(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        int colDiff = Math.abs(from.getColumn()-to.getColumn());
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        if(rowDiff < 1 || colDiff < 1 || rowDiff > 2 || colDiff > 2) return false;
        return (Math.abs(rowDiff - colDiff) == 1);
    }
}
