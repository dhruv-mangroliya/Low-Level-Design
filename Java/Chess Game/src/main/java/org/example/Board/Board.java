package org.example.Board;

import org.example.Components.Position;
import org.example.Enums.Colour;
import org.example.Enums.ResultState;
import org.example.Pieces.*;
import org.example.PlayerState.Player;
import org.example.PlayerState.PlayerTurnManager;
import org.example.Service.RuleEngine;

import java.util.Scanner;

public class Board {
    private Cell[][] board;

    public Board() {
        board = new Cell[8][8];

        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++) {
                Position position = new Position(row, col);
                board[row][col] = new Cell(position);
            }
        }

        setUpPieces();
    }

    private void setUpPieces(){
        for(int col=0;col<8;col++){
            board[1][col].setPiece(new Pawn(Colour.BLACK));
            board[6][col].setPiece(new Pawn(Colour.WHITE));
        }
        board[0][0].setPiece(new Rook(Colour.BLACK));
        board[0][1].setPiece(new Knight(Colour.BLACK));
        board[0][2].setPiece(new Bishop(Colour.BLACK));
        board[0][3].setPiece(new Queen(Colour.BLACK));
        board[0][4].setPiece(new King(Colour.BLACK));
        board[0][5].setPiece(new Bishop(Colour.BLACK));
        board[0][6].setPiece(new Knight(Colour.BLACK));
        board[0][7].setPiece(new Rook(Colour.BLACK));

        board[7][0].setPiece(new Rook(Colour.WHITE));
        board[7][1].setPiece(new Knight(Colour.WHITE));
        board[7][2].setPiece(new Bishop(Colour.WHITE));
        board[7][3].setPiece(new Queen(Colour.WHITE));
        board[7][4].setPiece(new King(Colour.WHITE));
        board[7][5].setPiece(new Bishop(Colour.WHITE));
        board[7][6].setPiece(new Knight(Colour.WHITE));
        board[7][7].setPiece(new Rook(Colour.WHITE));
        return;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }
}
