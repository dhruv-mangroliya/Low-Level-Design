package org.example.Factory;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.User;

@Setter
@Getter
public class UserFactory {
    public static User createUser(String name){
        return new User(name);
    }
}
