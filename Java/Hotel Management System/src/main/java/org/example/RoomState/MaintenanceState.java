package org.example.RoomState;

import org.example.Model.Room;

public class MaintenanceState implements RoomState{
    @Override
    public boolean checkIn(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is not available for check in/out because it is under maintenance");
        return false;
    }

    @Override
    public boolean checkOut(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is not available for check in/out because it is under maintenance");
        return false;
    }

    @Override
    public void markUnderMaintenance(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is already under maintenance");
    }

    @Override
    public void markAvailable(Room room) {
        System.out.println("Room no. "+room.getRoomId()+" is now available.");
        room.setRoomState(new AvailableState());
    }
}
