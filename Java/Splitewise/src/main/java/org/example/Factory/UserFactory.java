package org.example.Factory;

<<<<<<< HEAD
import org.example.Entities.User;

public class UserFactory {
    public static User createUser(String id) {
        return new User(id);
=======
import lombok.Getter;
import lombok.Setter;
import org.example.Entity.User;

@Setter
@Getter
public class UserFactory {
    public static User createUser(String name){
        return new User(name);
>>>>>>> main
    }
}
