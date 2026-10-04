package org.example.SearchRequest;

import lombok.Getter;
import lombok.Setter;
import org.example.Model.Hotel;
import org.example.SearchEngines.ZipCodeBasedSearchEngine;

import java.util.List;
@Setter
@Getter
public class ZipBasedSeachRequest extends Request{
    private Integer zipcode;
    private Integer budget;

    public ZipBasedSeachRequest(Integer zipcode, Integer budget){
        this.budget = budget;
        this.zipcode = zipcode;
    }

    @Override
    public List<Hotel> search() {
        return new ZipCodeBasedSearchEngine().search(this);
    }
}
