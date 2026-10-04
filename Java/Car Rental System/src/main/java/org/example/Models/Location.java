package org.example.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Location {
    private int zipcode;
    private String address;

    public Location(int zipcode, String address){
        this.address = address;
        this.zipcode = zipcode;
    }
}
