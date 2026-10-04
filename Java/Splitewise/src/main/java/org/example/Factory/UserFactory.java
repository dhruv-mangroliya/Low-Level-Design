package org.example.Factory;

import org.example.Entities.User;

public class UserFactory {
    public static User createUser(String id) {
        return new User(id);
    }
}
