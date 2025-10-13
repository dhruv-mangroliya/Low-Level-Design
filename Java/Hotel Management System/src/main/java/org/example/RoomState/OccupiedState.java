package org.example.RoomState;

import org.example.Model.Room;

public class OccupiedState implements RoomState{
    @Override
    public boolean checkIn(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is already occupied bu guests");
        return false;
    }

    @Override
    public boolean checkOut(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is Now vacant, You can accommodate others.");
        room.setRoomState(new AvailableState());
        return true;
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
