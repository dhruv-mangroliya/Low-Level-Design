package org.example.Service;

import org.example.Enums.BookingStatus;
import org.example.Model.Booking;

public class BookingCancellationService {
    public void cancelBooking(Booking booking){
        booking.setBookingStatus(BookingStatus.CANCELLED);
        booking.getRoom().
                getBookings().
                removeIf(b->
                        b.getUser().equals(booking.getUser()) &&
                        b.getStartDate().equals(booking.getStartDate()) &&
                        b.getEndDate().equals(booking.getEndDate()));
        booking.getUser().getMyBookings().removeIf(b->
                b.getUser().equals(booking.getUser()) &&
                        b.getStartDate().equals(booking.getStartDate()) &&
                        b.getEndDate().equals(booking.getEndDate()));
        return;
    }
}
