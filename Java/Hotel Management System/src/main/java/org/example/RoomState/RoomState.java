package org.example.RoomState;

import org.example.Model.Room;

public interface RoomState {
    public boolean checkIn(Room room);
    public boolean checkOut(Room room);
    public void markUnderMaintenance(Room room);
    public void markAvailable(Room room);
}
