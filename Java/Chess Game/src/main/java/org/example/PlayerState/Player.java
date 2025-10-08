package org.example.PlayerState;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.Colour;

@Getter
@Setter
public class Player {
    private Colour colour;
    public Player(Colour colour){
        this.colour = colour;
    }
}
