package org.example.Strategy;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.LiftCar;
import org.example.Components.Request;
import org.example.Enums.Direction;

import java.util.List;

@Setter
@Getter
public class NearestFirstStrategy {
    public static LiftCar findBestSuitableLift(List<LiftCar> liftCarList, Request request){
        LiftCar liftCar = null;
        int minDistance = 1000;
        int targetFloor = request.getDestinationFloor();

        for(LiftCar lift: liftCarList){
            int dist = Math.abs(targetFloor - lift.getCurrentFloor());
            if(isSuitable(lift, request)) {
                if (dist < minDistance) {
                    liftCar = lift;
                    minDistance = dist;
                }
            }
            System.out.println(dist + " dist for lift "+lift.getId() + " lift is at floor: "+lift.getCurrentFloor());
        }

        return liftCar;
    }

    private static boolean isSuitable(LiftCar liftCar, Request request){
        if(liftCar.getDirection() == Direction.IDLE) return true;

        if(request.getDirection() != liftCar.getDirection()) return false;

        if(liftCar.getDirection() == Direction.UP && request.getDestinationFloor() >= liftCar.getCurrentFloor()){
            return true;
        }
        if(liftCar.getDirection() == Direction.DOWN && request.getDestinationFloor() <= liftCar.getCurrentFloor()){
            return true;
        }

        return false;
    }
}
