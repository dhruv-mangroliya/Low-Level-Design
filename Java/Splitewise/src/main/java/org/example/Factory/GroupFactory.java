package org.example.Factory;


import org.example.Entities.Group;
import org.example.Entities.User;

import javax.sound.midi.SysexMessage;
import java.util.List;

public class GroupFactory {
    public static Group createGroup(List<User> members){
        for(User user: members){
            System.out.println(user.getUserID());
        }
        return new Group(members);
    }
}
