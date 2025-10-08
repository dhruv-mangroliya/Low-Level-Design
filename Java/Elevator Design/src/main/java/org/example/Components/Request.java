package org.example.Components;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.Direction;
import org.example.Enums.Source;

@Setter
@Getter
public class Request {
    private int destinationFloor;
    private Direction direction;
    private Source source;

    public Request(int destinationFloor, Direction direction, Source source){
        this.destinationFloor = destinationFloor;
        this.source = source;
        this.direction = direction;
    }
}
