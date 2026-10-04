package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;

public class Bishop extends Piece{
    public Bishop(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        int colDiff = Math.abs(from.getColumn()-to.getColumn());
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        int targetRow = to.getRow();
        int targetCol = to.getColumn();

        return (colDiff == rowDiff);
    }
}
