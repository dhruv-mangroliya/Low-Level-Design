package org.example.System;

import lombok.Getter;
import lombok.Setter;
import org.example.Model.*;
import org.example.RoomState.MaintenanceState;
import org.example.Service.BookMyRoomService;
import org.example.Service.BookingCancellationService;
import org.example.Service.ReviewService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class HotelManagementSystem {
    private static volatile HotelManagementSystem instance;
    private Map<String, List<Hotel>> citywiseHotels = new HashMap<>();
    private Map<Integer, List<Hotel>> zipwiseHotels = new HashMap<>();
    private List<User> users = new ArrayList<>();

    public static HotelManagementSystem getInstance(){
        if(instance == null){
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public void listHotel(Hotel hotel){
        String city = hotel.getLocation().getCity();
        Integer zip  = hotel.getLocation().getZipCode();

        getCitywiseHotels()
                .computeIfAbsent(city, k -> new ArrayList<>())
                .add(hotel);

        getZipwiseHotels()
                .computeIfAbsent(zip, k -> new ArrayList<>())
                .add(hotel);

    }

    public void listUser(User user){
        if(!this.users.contains(user))
            this.users.add(user);
        return;
    }

    public void addReview(Hotel hotel, Review review){
        ReviewService reviewService = new ReviewService();
        reviewService.addReview(review, hotel);
    }

    public List<Review> showReview(Hotel hotel){
        ReviewService reviewService = new ReviewService();
        return reviewService.fetchReviewsForHotel(hotel);
    }

    public void bookMyRoom(Booking booking){
        BookMyRoomService bookMyRoomService = new BookMyRoomService();
        if(bookMyRoomService.bookMyRoom(booking)){
            System.out.println("Booking Confirmed.");
        }else {
            System.out.println("Room is not available");
        }
    }

    public void cancelBooking(Booking booking){
        BookingCancellationService bookingCancellationService = new BookingCancellationService();
        bookingCancellationService.cancelBooking(booking);
        return;
    }

    public void markRoomUnderMaitenance(Room room){
        room.getRoomState().markUnderMaintenance(room);
        return;
    }

    public void checkIn(Room room){
        room.getRoomState().checkIn(room);
        return;
    }

    public void checkOut(Room room){
        room.getRoomState().checkOut(room);
        return;
    }

}
