package org.example.Model;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.BookingStatus;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Booking {
    private User user;
    private Hotel hotel;
    private Room room;
    private Integer paymentAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus bookingStatus;

    public Booking(User user, Hotel hotel, Room room, Integer paymentAmount, LocalDate start, LocalDate end){
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.paymentAmount = paymentAmount;
        this.startDate = start;
        this.endDate = end;
        this.bookingStatus = BookingStatus.CREATED;
    }

    @Override
    public String toString(){
        String str = "User: " + this.user.getName() + " | " + "Hotel : " + this.hotel.getName() + " | " +
                "Room No. : " + this.room.getRoomId() + " | " + "Price : " + this.room.getPrice() + " | " +
                "Starting from : " + this.startDate.toString() + " | " + "Ending on : " + this.endDate.toString() +
                " | " + "Booking Status : " + this.getBookingStatus().toString();
        return str;
    }
}
