package org.example;

import org.example.Board.Board;
import org.example.Game.Game;
import org.example.Game.TTTGame;
import org.example.Player.Player;
import org.example.Player.PlayerFactory;

public class TTTDemo{
    public static void main(String[] args) {
        TTTGame game = new TTTGame();
        game.play();
        return;
    }
}
