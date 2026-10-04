package org.example.Model;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.BookingStatus;
import org.example.Enums.Roomtype;
import org.example.Exceptions.RoomUnderMaintenance;
import org.example.RoomState.AvailableState;
import org.example.RoomState.MaintenanceState;
import org.example.RoomState.OccupiedState;
import org.example.RoomState.RoomState;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Room {
    private Roomtype roomtype;
    private Integer price;
    private String roomId;
    private RoomState roomState;
    private boolean isOccupied;
    private List<Booking> bookings;

    public Room(Roomtype roomtype, Integer price, String roomId){
        this.price = price;
        this.roomId = roomId;
        this.roomtype = roomtype;
        this.isOccupied = false;
        this.bookings = new ArrayList<>();
        this.roomState = new AvailableState();
    }

    public boolean isAvailable(Booking booking){
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();

        if(this.roomState instanceof MaintenanceState){
            booking.setBookingStatus(BookingStatus.CANCELLED);
            throw new RoomUnderMaintenance();
        }

        return (getBookings().
                stream().
                allMatch(b -> b.getEndDate().compareTo(startDate) <= 0 || b.getStartDate().compareTo(endDate) >= 0));
    }

    public void bookRoom(Booking booking){
        this.getBookings().add(booking);
        return;
    }
}
