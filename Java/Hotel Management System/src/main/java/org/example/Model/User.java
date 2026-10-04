package org.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    List<Booking> myBookings;

    public User(String id, String name){
        this.id = id;
        this.name = name;
        this.myBookings = new ArrayList<>();
    }

    public void showMyBookings(){
        if(myBookings.isEmpty()){
            System.out.println("No bookings found for "+this.getName());
            return;
        }
        myBookings.stream().forEach(b->System.out.println(b.toString()));
        return;
    }
}
