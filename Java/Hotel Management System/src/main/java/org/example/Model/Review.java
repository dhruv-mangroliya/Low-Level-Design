package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Review {
    private String details;
    private User user;

    public Review(String details, User user){
        this.details = details;
        this.user = user;
    }
}
