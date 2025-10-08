package org.example.Components;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.Direction;
import org.example.Observer.OutsideDisplay;
import org.example.States.IdleState;
import org.example.States.State;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;

@Setter
@Getter
public class LiftCar implements Runnable {
    private int id;
    private OutsideDisplay outsideDisplay;
    private boolean isRunning;
    private Direction direction;
    private int currentFloor;
    private TreeSet<Integer> upRequests = new TreeSet<>();
    private TreeSet<Integer> downRequests = new TreeSet<>(Comparator.reverseOrder());
    private State state;

    public LiftCar(int id){
        this.id = id;
        this.currentFloor = 1;
        this.outsideDisplay = new OutsideDisplay(this);
        this.isRunning = true;
        this.direction = Direction.IDLE;
        this.state = new IdleState();
    }

    public void move(){
        System.out.println("Move called on lift: "+this.getId()+ "... It's on the floor : "+this.getCurrentFloor());
        this.state.move(this);
    }

    public void stopLift(){
        isRunning = false;
    }

    public synchronized void addRequest(Request request){
        this.getState().addRequest(this, request);
    }

    @Override
    public void run() {
        while (isRunning){
            move();

            try{
                Thread.sleep(100);
            }catch (Exception e){
                isRunning = false;
            }
        }
    }
}
