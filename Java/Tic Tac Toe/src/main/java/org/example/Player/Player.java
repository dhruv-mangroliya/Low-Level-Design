package org.example.Player;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private char type;

    public Player(char ch){
        this.type = ch;
    }
}
