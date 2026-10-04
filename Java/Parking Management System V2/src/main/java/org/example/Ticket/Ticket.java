package org.example.Ticket;

import lombok.Getter;
import lombok.Setter;
import org.example.VehicleFactory.Vehicle;

import java.time.Instant;

@Getter
@Setter
public class Ticket {
    private String ticketNumber;
    private Instant entryTime;
    private Instant exitTime;
    private Vehicle vehicle;

    public Ticket(String ticketNumber, Instant start, Vehicle vehicle) {
        this.ticketNumber = ticketNumber;
        this.entryTime = start;
        this.vehicle = vehicle;
    }

    public void generateExitTime(){
        this.exitTime = Instant.now();
    }

    public long getDuration(){
        long duration = exitTime.getEpochSecond() - entryTime.getEpochSecond();
        System.out.println("Duration for this vehicle ID : " + this.vehicle.getVehicleNumber() + "is " + duration);
        return duration;
    }
}
