package org.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Hotel {
    private String name;
    private Location location;
    private List<Room> rooms = new ArrayList<>();
    private Integer rating = 0;
    private List<Review> reviews = new ArrayList<>();
    private String hotelId;

    public Hotel(String name, Location location, String id){
        this.name = name;
        this.location = location;
        this.hotelId = id;
    }
}
