package org.example.States;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.LiftCar;
import org.example.Components.Request;
import org.example.Enums.Direction;
import org.example.Enums.Source;

@Setter
@Getter
public class MovingDown implements State {
    @Override
    public void move(LiftCar liftCar) {
        if(liftCar.getDownRequests().isEmpty()){
            liftCar.setDirection(Direction.IDLE);
            return;
        }
        liftCar.setCurrentFloor(liftCar.getCurrentFloor()-1);
        if(liftCar.getDownRequests().first() == liftCar.getCurrentFloor()){
            liftCar.getDownRequests().pollFirst();
        }

        if(liftCar.getDownRequests().isEmpty()){
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

        if(request.getDirection() == Direction.DOWN && request.getDestinationFloor() <= liftCar.getCurrentFloor()){
            liftCar.getDownRequests().add(request.getDestinationFloor());
        }else{
            liftCar.getUpRequests().add(request.getDestinationFloor());
        }
    }
}
