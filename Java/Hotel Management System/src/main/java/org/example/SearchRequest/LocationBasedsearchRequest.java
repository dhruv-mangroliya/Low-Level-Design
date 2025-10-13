package org.example.SearchRequest;

import lombok.Getter;
import lombok.Setter;
import org.example.Model.Hotel;
import org.example.SearchEngines.LocationBasedSeachEngine;
import org.example.System.HotelManagementSystem;

import javax.naming.directory.SearchResult;
import java.util.List;

@Setter
@Getter
public class LocationBasedsearchRequest extends Request{
    private String cityName;
    private Integer budget;

    public LocationBasedsearchRequest(String cityName, Integer budget){
        this.budget = budget;
        this.cityName = cityName;
    }

    @Override
    public List<Hotel> search() {
        return new LocationBasedSeachEngine().search(this);
    }
}
