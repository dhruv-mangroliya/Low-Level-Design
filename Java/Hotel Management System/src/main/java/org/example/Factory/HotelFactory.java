package org.example.Factory;

import org.example.Model.Hotel;
import org.example.Model.Location;
import org.example.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
    public Hotel createHotel(String name, Location location, String Id){
        return new Hotel(name, location, Id);
    }

    public void addRooms(Hotel hotel, Room room){
        List<Room> list;
        list = hotel.getRooms();
        if(list.isEmpty()){
            list = new ArrayList<>();
        }
        list.add(room);
        hotel.setRooms(list);
        return;
    }
}
