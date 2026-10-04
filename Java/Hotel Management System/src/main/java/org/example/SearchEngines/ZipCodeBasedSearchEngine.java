package org.example.SearchEngines;

import org.example.Exceptions.WrongRequestTypeSent;
import org.example.Model.Hotel;
import org.example.Model.Room;
import org.example.SearchRequest.LocationBasedsearchRequest;
import org.example.SearchRequest.Request;
import org.example.SearchRequest.ZipBasedSeachRequest;
import org.example.System.HotelManagementSystem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ZipCodeBasedSearchEngine implements SearchEngineCore {

    @Override
    public List<Hotel> search(Request request) {
        if (!(request instanceof ZipBasedSeachRequest)) {
            throw new WrongRequestTypeSent();
        }

        ZipBasedSeachRequest req = (ZipBasedSeachRequest) request;
        Integer budget = req.getBudget();
        Integer zipcode = req.getZipcode();

        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();
        List<Hotel> hotelsInZC = hotelManagementSystem.getZipwiseHotels().getOrDefault(zipcode, List.of());
        return hotelsInZC.stream()
                .filter(hotel -> hotel.getLocation().getZipCode().equals(zipcode))
                .filter(hotel -> hotel.getRooms().stream().anyMatch(r -> r.getPrice() <= budget))
                .toList();
    }
}
