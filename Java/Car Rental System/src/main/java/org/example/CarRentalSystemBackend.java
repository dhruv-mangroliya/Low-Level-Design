package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.*;

import javax.sound.midi.SysexMessage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
public class CarRentalSystemBackend {
    private List<Shop> shops = new ArrayList<>();
    private ReservationManager reservationManager = ReservationManager.getReservationManager();
    private static CarRentalSystemBackend carRentalSystemBackend;
    private Map<User, List<Reservation>> userBookings = new HashMap<>();

    public static synchronized CarRentalSystemBackend createRentalSystem(){
        if(carRentalSystemBackend == null){
            carRentalSystemBackend = new CarRentalSystemBackend();
        }
        return carRentalSystemBackend;
    }

    public void addShop(Shop shop){
        this.shops.add(shop);
        return;
    }

    public void createReservation(User user, String plateNumber, LocalDateTime startDate, LocalDateTime endDate){
        Vehicle vehicle = fetchVehicle(plateNumber);
        Shop selectedShop = fetchShop(plateNumber);

        if (vehicle == null || selectedShop == null) {
            System.out.println("Vehicle/Shop not found!");
            return;
        }

        if(!reservationManager.isAvailable(vehicle, startDate, endDate)){
            return;
        }

        Reservation reservation = reservationManager.createReservation(vehicle, startDate, endDate);
        List<Reservation> bookings = userBookings.get(user);
        if(bookings == null) bookings = new ArrayList<>();

        bookings.add(reservation);
        userBookings.put(user, bookings);

        return;
    }

    public Vehicle fetchVehicle(String plateNumber){
        return carRentalSystemBackend.getShops().stream()
                .flatMap(shop -> shop.getVehicles().stream())
                .filter(v -> v.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null);
    }

    public Shop fetchShop(String plateNumber){
        return carRentalSystemBackend.getShops().stream()
                .filter(shop -> shop.getVehicles()
                        .stream()
                        .anyMatch(v -> v.getPlateNumber().equals(plateNumber)))
                .findFirst()
                .orElse(null);
    }

    public void showMyBookings(User user){
        List<Reservation> bookings = userBookings.get(user);
        if(bookings.isEmpty()){
            System.out.println("No booking found! "+user.getName());
            return;
        }
        for(Reservation r: bookings){
           r.printBooking();
           System.out.println();
        }
        return;
    }
}
