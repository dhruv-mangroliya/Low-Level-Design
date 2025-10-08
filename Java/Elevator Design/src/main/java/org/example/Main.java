package org.example;


import lombok.SneakyThrows;
import org.example.Components.LiftSystem;
import org.example.Enums.Direction;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        LiftSystem liftSystem = LiftSystem.getInstance(10, 2);
        liftSystem.start();

        System.out.println("Elevator system started. ConsoleDisplay is observing.\n");

        Thread.sleep(1000);

        liftSystem.addRequest(5, Direction.UP);
        Thread.sleep(7000);

        liftSystem.addRequest(8, Direction.DOWN);
        Thread.sleep(4000);

        liftSystem.selectFloor(1, 9);
        liftSystem.selectFloor(2, 4);
        liftSystem.addRequest(2, Direction.UP);
        Thread.sleep(4000);

        liftSystem.shutdown();
    }
}