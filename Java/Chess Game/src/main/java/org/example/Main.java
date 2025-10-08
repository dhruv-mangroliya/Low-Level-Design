package org.example;

import org.example.Game.ChessGame;
import org.example.Game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new ChessGame();
        game.startGame();
    }
}