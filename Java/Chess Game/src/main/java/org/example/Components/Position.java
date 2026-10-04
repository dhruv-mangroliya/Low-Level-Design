package org.example.Components;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int row;
    private int column;

    public Position(int i, int j){
        this.row = i;
        this.column = j;
    }
}
