package org.example.Model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private String city;
    private String location;
    private Integer zipCode;

    public Location(String city, String location, Integer zip){
        this.city = city;
        this.zipCode = zip;
        this.location = location;
    }
}
