package org.example.SearchEngines;

import org.example.Exceptions.WrongRequestTypeSent;
import org.example.Model.Hotel;
import org.example.Model.Room;
import org.example.SearchRequest.LocationBasedsearchRequest;
import org.example.SearchRequest.Request;
import org.example.SearchRequest.ZipBasedSeachRequest;
import org.example.System.HotelManagementSystem;

import java.util.*;
import java.util.stream.Collectors;

public class LocationBasedSeachEngine implements SearchEngineCore {

    @Override
    public List<Hotel> search(Request request) {
        if (!(request instanceof LocationBasedsearchRequest)) {
            throw new WrongRequestTypeSent();
        }

        LocationBasedsearchRequest req = (LocationBasedsearchRequest) request;
        Integer budget = req.getBudget();
        String city = req.getCityName();

        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();
        List<Hotel> hotelsInCity = hotelManagementSystem.getCitywiseHotels().getOrDefault(city, List.of());
        return hotelsInCity.stream()
                .filter(hotel -> hotel.getLocation().getCity().equals(city))
                .filter(hotel -> hotel.getRooms().stream().anyMatch(r -> r.getPrice() <= budget))
                .toList();
    }
}
