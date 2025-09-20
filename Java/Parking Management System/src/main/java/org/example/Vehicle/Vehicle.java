package org.example.Vehicle;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public abstract class Vehicle {
    private String type;
    private String license;
    private VehicleSize size;
    private long entryTimeSecond;

    Vehicle(String license, VehicleSize size, String type){
        this.license = license;
        this.size = size;
        this.type = type;
        this.entryTimeSecond = Instant.now().getEpochSecond();
    }
}
