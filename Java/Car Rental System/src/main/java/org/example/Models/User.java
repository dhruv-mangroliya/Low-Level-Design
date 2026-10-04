package org.example.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userId;
    private String license;
    private String name;

    public User(int userId, String license, String name){
        this.license = license;
        this.userId = userId;
        this.name = name;
    }
}
