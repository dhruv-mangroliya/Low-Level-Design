package org.example;

import org.example.Enums.Roomtype;
import org.example.Factory.HotelFactory;
import org.example.Factory.RoomFactory;
import org.example.Factory.UserFactory;
import org.example.Model.*;
import org.example.SearchRequest.LocationBasedsearchRequest;
import org.example.SearchRequest.ZipBasedSeachRequest;
import org.example.System.HotelManagementSystem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();
        HotelFactory hotelFactory = new HotelFactory();
        RoomFactory roomFactory = new RoomFactory();
        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();

        //___________________________USER_CREATION________________________________
        User user1 = userFactory.createUser("User001", "Dhruv Mangroliya");
        User user2 = userFactory.createUser("User002", "Jay Mangroliya");

        //___________________________HOTEL_CREATION________________________________
        Location location1 = new Location("Surat", "Varachha", 395008);
        Hotel hotel1 = hotelFactory.createHotel("Seven Star", location1, "Hotel001");
        Room room1 = roomFactory.createRoom(Roomtype.SIMPLE, 1000, "Room001");
        Room room2 = roomFactory.createRoom(Roomtype.SIMPLE, 1100, "Room002");
        Room room3 = roomFactory.createRoom(Roomtype.SPECIAL, 2000, "Room003");
        Room room4 = roomFactory.createRoom(Roomtype.SPECIAL, 2100, "Room004");
        Room room5 = roomFactory.createRoom(Roomtype.BUSINESS, 3000, "Room005");
        Room room6 = roomFactory.createRoom(Roomtype.BUSINESS, 3100, "Room006");
        hotelFactory.addRooms(hotel1, room1);
        hotelFactory.addRooms(hotel1, room2);
        hotelFactory.addRooms(hotel1, room3);
        hotelFactory.addRooms(hotel1, room4);
        hotelFactory.addRooms(hotel1, room5);
        hotelFactory.addRooms(hotel1, room6);

        //_____________________ADDING_HOTEL/USER_INTO_THE_SYSTEM________________________
        hotelManagementSystem.listHotel(hotel1);
        hotelManagementSystem.listUser(user1);
        hotelManagementSystem.listUser(user2);


        //_____________________CITY_HOTEL_SEARCH_SIMULATION_____________________________
        LocationBasedsearchRequest request1 = new LocationBasedsearchRequest("Surat", 1200);
        List<Hotel> response = request1.search();
        response.stream().forEach(h -> System.out.println(h.getName()));

        //_____________________ZIPCODE_HOTEL_SEARCH_SIMULATION_____________________________
        ZipBasedSeachRequest request2 = new ZipBasedSeachRequest(395005, 1200);
        List<Hotel> response2 = request2.search();
        response2.stream().forEach(h -> System.out.println(h.getName()));

        //______________________REVIEW_ADDITION_SIMULATION_______________________________
        Review review = new Review("Really 5 ***** hotel based in surat...", user1);
        hotelManagementSystem.addReview(hotel1, review);
        List<Review> reviewList = hotelManagementSystem.showReview(hotel1);
        reviewList.stream().forEach(r -> System.out.println(r.getDetails()));

        //_____________________BOOKING_SIMULATION_____________________________
        Booking booking1 = new Booking(user1, hotel1, room2, 1100, LocalDate.now(), LocalDate.now().plusDays(4));
        hotelManagementSystem.bookMyRoom(booking1);
        user1.showMyBookings();
        hotelManagementSystem.cancelBooking(booking1);
        user1.showMyBookings();

        //_____________________ROOM_MAINTENANCE_SIMULATION_____________________________
        hotelManagementSystem.markRoomUnderMaitenance(room1);
        Booking booking2 = new Booking(user2, hotel1, room1, 1100, LocalDate.now(), LocalDate.now().plusDays(4));
        hotelManagementSystem.bookMyRoom(booking2);  //(WILL THROW ERROR HERE)

        //_____________________CHECK_IN/OUT_SIMULATION_____________________________
        hotelManagementSystem.checkIn(room2);
        hotelManagementSystem.checkOut(room2);
        hotelManagementSystem.checkIn(room2);
        hotelManagementSystem.checkIn(room2);
    }
}