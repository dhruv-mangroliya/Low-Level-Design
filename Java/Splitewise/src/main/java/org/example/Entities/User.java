package org.example.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userID;

    public User(String id){
        this.userID = id;
    }
}
