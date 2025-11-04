package org.example.Factories;

import org.example.Models.User;

public class UserFactory {
    public static User createUser(int userId, String license, String name){
        return new User(userId, license, name);
    }
}
