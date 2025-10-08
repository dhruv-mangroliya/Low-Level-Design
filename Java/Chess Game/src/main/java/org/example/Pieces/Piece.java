package org.example.Pieces;

import lombok.Getter;
import lombok.Setter;
import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;
import org.example.Enums.PieceType;

@Getter
@Setter
public abstract class Piece {
    private Colour colour;
    private boolean isKilled;

    public Piece(Colour colour){
        this.colour = colour;
        this.isKilled = false;
    }

    public abstract boolean canMove(Board board, Position from, Position to);
}
