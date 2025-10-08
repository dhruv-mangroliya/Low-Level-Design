package org.example.Game;

import org.example.Board.Board;
import org.example.Board.Cell;
import org.example.Components.Position;
import org.example.Enums.Colour;
import org.example.Enums.ResultState;
import org.example.Exceptions.IllegalPieceChoosen;
import org.example.Exceptions.InvalidMoveForPiece;
import org.example.Exceptions.PieceNotFound;
import org.example.Exceptions.SameTypeOfPiece;
import org.example.Pieces.King;
import org.example.Pieces.Piece;
import org.example.PlayerState.Player;
import org.example.PlayerState.PlayerTurnManager;
import org.example.Service.RuleEngine;

import java.util.Scanner;

public class ChessGame implements Game{
    private ResultState resultState;
    private Board board;
    private PlayerTurnManager playerTurnManager;

    public ChessGame() {
        resultState = ResultState.ONGOING;
        board = new Board();
        Player player1 = new Player(Colour.BLACK);
        Player player2 = new Player(Colour.WHITE);
        playerTurnManager = new PlayerTurnManager(player1, player2);
    }
    @Override
    public void startGame(){

        System.out.println("Player1 will be Black. Player 2 will be White.");
        System.out.println();

        Player currentPlayer;
        Scanner sc = new Scanner(System.in);

        while(resultState == ResultState.ONGOING){
            currentPlayer = playerTurnManager.whoseTurn();
            System.out.println(currentPlayer.getColour()+" Please it's your turn.");

            boolean isValidMove = false;
            while(!isValidMove){
                System.out.println("Enter piece's current location in this form: A B");
                Position from = takePosition(sc);
                System.out.println("Enter piece's next location in this form: A B");
                Position to = takePosition(sc);

                isValidMove = validateMove(from, to, currentPlayer);
            }
            validateDrawAndChangeTurn(currentPlayer);
        }
    }

    private Position takePosition(Scanner sc){
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Position(row, col);
    }

    private void DisplayResult(){
        if(this.resultState == ResultState.DRAW) System.out.println("Result : Draw");
        if(this.resultState == ResultState.PLAYER_1_WIN) System.out.println("Result : Black won");
        if(this.resultState == ResultState.PLAYER_2_WIN) System.out.println("Result : White won");
        return;
    }

    private boolean validateMove(Position from, Position to, Player currentPlayer) {
        try {
            // is there even a piece?
            Cell fromCell = board.getCell(from.getRow(), from.getColumn());
            Piece fromPiece = fromCell.getPiece();
            if (fromPiece == null) {
                throw new PieceNotFound();

            }

            //not valid pattern move for selected piece.
            if(!fromPiece.canMove(board, from, to)){
                System.out.println("Hi am invalid.................");
                throw new InvalidMoveForPiece();
            }

            // match colour with player's colour
            if (fromPiece.getColour() != currentPlayer.getColour()) {
                throw new IllegalPieceChoosen();
            }

            // if target cell has own piece, don't move
            Cell toCell = board.getCell(to.getRow(), to.getColumn());
            Piece toPiece = toCell.getPiece();
            if (toPiece != null && fromPiece.getColour() == toPiece.getColour()) {
                throw new SameTypeOfPiece();
            }

            // if target cell has opponent piece, then kill it
            if (toPiece != null) {
                toPiece.setKilled(true);
                toCell.setPiece(null);
                System.out.println(currentPlayer.getColour().toString() + " killed piece...");
            }

            // move piece
            toCell.setPiece(fromPiece);
            fromCell.setPiece(null);

            if (toPiece instanceof King) {
                this.resultState = (currentPlayer.getColour() == Colour.WHITE) ? ResultState.PLAYER_2_WIN : ResultState.PLAYER_1_WIN;
                DisplayResult();
            }

            return true;

        } catch (PieceNotFound | SameTypeOfPiece | IllegalPieceChoosen e) {
            // print error message instead of stopping game
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            // catch-all to avoid unexpected crashes
            System.out.println("Unexpected error: " + e.getMessage());
            return false;
        }
    }
    private void validateDrawAndChangeTurn(Player currentPlayer){
        boolean drawCase1 = RuleEngine.isStalemate(currentPlayer);
        playerTurnManager.changeTurn();
        boolean drawCase2 = RuleEngine.isStalemate(currentPlayer);
        if(drawCase1 || drawCase2){
            resultState = ResultState.DRAW;
            DisplayResult();
        }
    }
}
