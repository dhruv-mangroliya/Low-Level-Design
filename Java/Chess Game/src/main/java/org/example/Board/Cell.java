package org.example.Board;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.Position;
import org.example.Enums.Colour;
import org.example.Enums.PieceType;
import org.example.Pieces.Piece;

@Setter
@Getter
public class Cell {
    private Colour colour;
    private Piece piece;
    private Position position;

    public Cell(Position position){
        this.position = position;
        this.piece = null;
    }

    public boolean setPiece(Piece piece){
        if(this.getPiece() == null){
            this.piece = piece;
            return true;
        }
        return false;
    }

    public void setUpCell(Colour colour, Piece piece){
        this.colour = colour;
        this.piece = piece;
    }
}
