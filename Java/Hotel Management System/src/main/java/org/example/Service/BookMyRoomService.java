package org.example.Service;

import org.example.Enums.BookingStatus;
import org.example.Model.Booking;
import org.example.Model.Hotel;
import org.example.Model.Room;

import java.util.List;

public class BookMyRoomService {
    public boolean bookMyRoom(Booking booking){
        booking.setBookingStatus(BookingStatus.PROCESSING);
        Hotel hotel = booking.getHotel();
        Room selectedRoom = booking.getRoom();
        boolean isAvailable = selectedRoom.isAvailable(booking);
        if(isAvailable) {
            selectedRoom.bookRoom(booking);
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            booking.getUser().getMyBookings().add(booking);
            return isAvailable;
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        return isAvailable;
    }
}
