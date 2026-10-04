package org.example.Factory;

import org.example.Enums.Roomtype;
import org.example.Model.Room;

public class RoomFactory {
    public Room createRoom(Roomtype roomtype, Integer price, String roomid){
        return new Room(roomtype, price, roomid);
    }
}
