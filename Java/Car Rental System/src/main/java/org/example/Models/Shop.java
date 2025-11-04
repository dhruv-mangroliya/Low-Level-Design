package org.example.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Shop {
    private int shopId;
    private String shopName;
    private Location location;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Shop(int shopId, String shopName, Location location){
        this.location = location;
        this.shopName = shopName;
        this.shopId = shopId;
    }

    public void addVehicle(Vehicle vehicle){
        this.getVehicles().add(vehicle);
        return;
    }
}
