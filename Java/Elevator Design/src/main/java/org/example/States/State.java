package org.example.States;

import org.example.Components.LiftCar;
import org.example.Components.Request;

public interface State {
    public void move(LiftCar liftCar);
    public void addRequest(LiftCar liftCar, Request request);
}
