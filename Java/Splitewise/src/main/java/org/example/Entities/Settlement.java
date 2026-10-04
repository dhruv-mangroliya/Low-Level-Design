package org.example.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Settlement {
    private Map<User, Map<User, Double>> settlementTranscations;

    public Settlement(Map<User, Map<User, Double>> data){
        this.settlementTranscations = data;
    }
}
