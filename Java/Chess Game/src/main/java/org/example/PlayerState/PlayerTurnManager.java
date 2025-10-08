package org.example.PlayerState;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerTurnManager {
    private Player player1;
    private Player player2;
    private boolean player1Turn = true;

    public PlayerTurnManager(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }

    public Player changeTurn(){
        if(player1Turn){
            player1Turn = !player1Turn;
            return player2;
        }else {
            player1Turn = !player1Turn;
            return player1;
        }
    }

    public Player whoseTurn(){
        if(player1Turn) return player1;
        return player2;
    }
}
