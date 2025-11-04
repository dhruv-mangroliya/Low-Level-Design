package org.example;


import org.example.Facade.CarRentalSystemFacade;
import org.example.Factories.UserFactory;
import org.example.Models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CarRentalSystemBackend carRentalSystemBackend = CarRentalSystemBackend.createRentalSystem();
        CarRentalSystemFacade.startCarRentalSystem(carRentalSystemBackend);

        User user = UserFactory.createUser(100, "LIC-001", "Dhruv Mangroliya");

        carRentalSystemBackend.createReservation(user, "GJ-14-IZ-781",
                LocalDateTime.of(2025, 11, 4, 1, 30),
                LocalDateTime.of(2025, 11, 5, 23, 30));
        carRentalSystemBackend.createReservation(user, "GJ-06-FY-324",
                LocalDateTime.of(2025, 11, 4, 1, 30),
                LocalDateTime.of(2025, 11, 4, 23, 30));
        carRentalSystemBackend.showMyBookings(user);

    }
}