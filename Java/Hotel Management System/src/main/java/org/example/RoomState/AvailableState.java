package org.example.RoomState;

import org.example.Model.Room;

public class AvailableState implements RoomState{

    @Override
    public boolean checkIn(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is now occupied bu guests");
        room.setOccupied(true);
        room.setRoomState(new OccupiedState());
        return true;
    }

    @Override
    public boolean checkOut(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is already vacant.");
        return false;
    }

    @Override
    public void markUnderMaintenance(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is now under maintenance");
        room.setRoomState(new MaintenanceState());
    }

    @Override
    public void markAvailable(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is already available.");
    }
}
