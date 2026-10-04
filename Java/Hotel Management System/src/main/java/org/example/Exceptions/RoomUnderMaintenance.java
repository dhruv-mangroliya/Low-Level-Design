package org.example.Exceptions;

public class RoomUnderMaintenance extends RuntimeException {
    public RoomUnderMaintenance() {
        super("Room is under the maintenance.");
    }
}
