package org.example;

import org.example.Board.Board;
import org.example.Player.Player;

public class TTTDemo {
    public static void main(String[] args) {
        Board board = Board.getInstance();
        Player p1 = new Player('O');
        Player p2 = new Player('X');

        board.setFirstPlayer(p1);

        board.makeMove(p1, 1);
        board.showBoard();

        board.makeMove(p2, 2);
        board.showBoard();

        board.makeMove(p1, 4);
        board.showBoard();

        board.makeMove(p2, 5);
        board.showBoard();

        board.makeMove(p1, 7);
        board.showBoard();

        board.makeMove(p1, 8);
        board.showBoard();

        board.makeMove(p2, 8);
        board.showBoard();

        return;
    }
}
