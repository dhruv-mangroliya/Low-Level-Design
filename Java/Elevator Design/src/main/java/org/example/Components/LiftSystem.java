package org.example.Components;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.Direction;
import org.example.Enums.Source;
import org.example.Strategy.LiftMovingStrategy;
import org.example.Strategy.NearestFirstStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Setter
@Getter
public class LiftSystem {
    private static volatile LiftSystem instance;
    private int floors;
    private int noOfLifts;
    private List<LiftCar> lifts = new ArrayList<>();
    private Map<Integer, LiftCar> liftBook = new HashMap<>();
    private ExecutorService executorService;

    public LiftSystem(int floors, int noOfLifts){
        this.noOfLifts = noOfLifts;
        this.floors = floors;
        this.executorService = Executors.newFixedThreadPool(noOfLifts);

        for(int i=0;i<noOfLifts;i++){
            LiftCar lift = new LiftCar(i+1);
            lifts.add(lift);
            liftBook.put(i+1, lift);
        }
    }

    public static synchronized LiftSystem getInstance(int floors, int numElevators) {
        if (instance == null) {
            instance = new LiftSystem(floors, numElevators);
        }
        return instance;
    }

    public void start(){
        for(LiftCar lift: lifts){
            executorService.submit(lift);
        }
    }

    public void shutdown() {
        System.out.println("Shutting down elevator system...");
        for (LiftCar elevator : liftBook.values()) {
            elevator.stopLift();
        }
        executorService.shutdown();
    }

    public void addRequest(int floor, Direction direction){
        Request request = new Request(floor, direction, Source.EXTERNAL);

        LiftCar response = NearestFirstStrategy.findBestSuitableLift(this.getLifts(), request);
        if(response == null){
            System.out.println("System is busy, please try again...");
        }else{
            System.out.println(response.getId() + " lift is assigned to reach at floor "+floor);
            response.addRequest(request);
        }

        return;
    }

    public void selectFloor(int liftId, int destinationFloor) {
        System.out.println("\n>> INTERNAL Request: User in lift " + liftId + " selected floor " + destinationFloor);
        Request request = new Request(destinationFloor, Direction.IDLE, Source.INTERNAL);

        LiftCar lift = liftBook.get(liftId);
        if (lift != null) {
            lift.addRequest(request);
        } else {
            System.err.println("Invalid elevator ID.");
        }
    }
}
