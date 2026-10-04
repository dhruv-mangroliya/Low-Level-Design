package org.example.Pieces;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;

public class Pawn extends Piece{
    public Pawn(Colour colour){
        super(colour);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(to.getColumn() - from.getColumn());

        if (this.getColour() == Colour.BLACK) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (from.getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && board.getCell(to.getRow(), to.getColumn()).getPiece() != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (from.getRow() == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && board.getCell(to.getRow(), to.getColumn()).getPiece() != null);
        }
    }
}
