package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;

public class Rook extends Piece{
    public Rook(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        int colDiff = Math.abs(from.getColumn()-to.getColumn());
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        return (colDiff == 0) || (rowDiff == 0);
    }
}
