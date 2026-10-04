package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    public String name;
    public Balancesheet balancesheet;

    public User(String name){
        this.name = name;
    }
}
