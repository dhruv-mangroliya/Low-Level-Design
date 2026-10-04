package org.example.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BalanceSheet {
    private Map<User, Map<User, Double>> amountData;

    public BalanceSheet(Map<User, Map<User, Double>> sheet){
        this.amountData = sheet;
    }
}
