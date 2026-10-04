package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;

public class Queen extends Piece{
    public Queen(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        if(from.getRow() == to.getRow() && from.getColumn() == to.getColumn()) return false;
        int colDiff = Math.abs(from.getColumn()-to.getColumn());
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        return (colDiff == rowDiff) || (rowDiff == 0) || (colDiff == 0);
    }
}
