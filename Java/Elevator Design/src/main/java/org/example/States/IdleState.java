package org.example.States;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.LiftCar;
import org.example.Components.Request;
import org.example.Enums.Direction;

@Setter
@Getter
public class IdleState implements State{
    @Override
    public void move(LiftCar liftCar) {
        if(!liftCar.getUpRequests().isEmpty()){
            System.out.println("Lift: "+liftCar.getId()+" direction setted to UP");
            liftCar.setDirection(Direction.UP);
            liftCar.setState(new MovingUp());
        }else if(!liftCar.getDownRequests().isEmpty()){
            System.out.println("Lift: "+liftCar.getId()+" direction setted to DOWN");
            liftCar.setDirection(Direction.DOWN);
            liftCar.setState(new MovingDown());
        }
    }

    @Override
    public void addRequest(LiftCar liftCar, Request request){
        if(liftCar.getCurrentFloor() > request.getDestinationFloor()){
            liftCar.getDownRequests().add(request.getDestinationFloor());
        }else if(liftCar.getCurrentFloor() < request.getDestinationFloor()){
            liftCar.getUpRequests().add(request.getDestinationFloor());
        }
    }
}
