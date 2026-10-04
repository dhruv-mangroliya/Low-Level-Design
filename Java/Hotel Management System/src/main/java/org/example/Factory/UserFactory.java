package org.example.Factory;

import org.example.Model.User;

public class UserFactory {
    public User createUser(String id, String name){
        return new User(id, name);
    }
}
