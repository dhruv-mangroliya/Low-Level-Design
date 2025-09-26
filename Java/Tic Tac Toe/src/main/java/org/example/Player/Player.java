package org.example.Player;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private char type;
    private String name;

    public Player(char ch, String name){
        this.type = ch;
        this.name = name;
    }
}
