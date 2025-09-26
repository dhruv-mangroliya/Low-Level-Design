package org.example.Player;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerFactory {
    public Player createPlayer(char ch, String name){
        return new Player(ch, name);
    }
}
