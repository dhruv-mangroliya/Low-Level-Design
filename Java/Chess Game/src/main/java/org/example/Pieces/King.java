package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;
import org.example.Enums.PieceType;
import org.example.Main;

public class King extends Piece{
    public King(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        if(from.getRow() == to.getRow() && from.getColumn() == to.getColumn()) return false;
        return (Math.abs(from.getRow() - to.getRow()) <= 1 && Math.abs(from.getColumn() - to.getColumn()) <= 1);
    }
}
