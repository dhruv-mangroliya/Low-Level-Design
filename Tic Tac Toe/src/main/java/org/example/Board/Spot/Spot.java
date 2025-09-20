package org.example.Board.Spot;

import lombok.Getter;
import lombok.Setter;
import org.example.Player.Player;

@Getter @Setter
public class Spot {
    private Player player;

    public Spot(){
        this.player = null;
    }
}
