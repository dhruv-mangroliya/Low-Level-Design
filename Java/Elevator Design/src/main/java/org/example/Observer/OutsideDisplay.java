package org.example.Observer;

import lombok.Getter;
import lombok.Setter;
import org.example.Components.LiftCar;
@Setter
@Getter
public class OutsideDisplay {
    private LiftCar liftCar;

    public OutsideDisplay(LiftCar liftCar){
        this.liftCar = liftCar;
    }

    public void showCurrentLocation(){
        System.out.println("Lift "+ this.liftCar.getId()+" is at : "+this.liftCar.getCurrentFloor()+"th floor.");
    }
}
