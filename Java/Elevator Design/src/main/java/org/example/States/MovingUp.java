package org.example.States;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.LiftCar;
import org.example.Components.Request;
import org.example.Enums.Direction;
import org.example.Enums.Source;

@Setter
@Getter
public class MovingUp implements State {
    @Override
    public void move(LiftCar liftCar) {
        if(liftCar.getUpRequests().isEmpty()){
            liftCar.setDirection(Direction.IDLE);
            return;
        }
        int nextFloor = liftCar.getCurrentFloor()+1;
        liftCar.setCurrentFloor(nextFloor);
        if(liftCar.getUpRequests().first() == liftCar.getCurrentFloor()){
            liftCar.getUpRequests().pollFirst();
        }

        if(liftCar.getUpRequests().isEmpty()){
            liftCar.setDirection(Direction.IDLE);
            liftCar.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(LiftCar liftCar, Request request){
        if(request.getSource() == Source.INTERNAL){
            if(request.getDestinationFloor() >= liftCar.getCurrentFloor()){
                liftCar.getUpRequests().add(request.getDestinationFloor());
            }else{
                liftCar.getDownRequests().add(request.getDestinationFloor());
            }
        }

        if(request.getDirection() == Direction.UP && request.getDestinationFloor() >= liftCar.getCurrentFloor()){
            liftCar.getUpRequests().add(request.getDestinationFloor());
        }else{
            liftCar.getDownRequests().add(request.getDestinationFloor());
        }
    }
}
