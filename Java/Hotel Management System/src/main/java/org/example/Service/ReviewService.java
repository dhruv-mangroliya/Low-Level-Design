package org.example.Service;

import org.example.Model.Hotel;
import org.example.Model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    public void addReview(Review review, Hotel hotel){
        hotel.getReviews().add(review);
        return;
    }

    public List<Review> fetchReviewsForHotel(Hotel hotel){
        List<Review> response = hotel.getReviews();
        if(response.isEmpty()) response = new ArrayList<>();
        return response;
    }
}
