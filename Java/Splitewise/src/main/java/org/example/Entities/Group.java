package org.example.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Group {
    private List<User> members;
    private BalanceSheet balanceSheet;

    public Group(List<User> members){
        this.members = members;
        Map<User, Map<User, Double>> sheet = new HashMap<>();

        for(User user1: members){
            Map<User, Double> user1Data = new HashMap<>();
            for(User user2: members){
                if(user1.getUserID().equals(user2.getUserID())) continue;
                user1Data.put(user2, 0.0);
            }
            sheet.put(user1, user1Data);
        }
        this.balanceSheet = new BalanceSheet(sheet);
    }
}
