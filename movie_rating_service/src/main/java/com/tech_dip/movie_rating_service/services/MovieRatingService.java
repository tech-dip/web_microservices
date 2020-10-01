package com.tech_dip.movie_rating_service.services;

import com.tech_dip.movie_rating_service.modal.Rating;
import com.tech_dip.movie_rating_service.modal.UserRating;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieRatingService {

    public UserRating getRatingList(int userId) {
        List<Rating> ratings = Arrays.asList(new Rating(1,1,5),new Rating(2,2,7),new Rating(1,3,8) );
         List<Rating> ratingList = ratings.stream().filter(it -> it.getUserId() == userId).collect(Collectors.toList());
         UserRating userRating = new UserRating();
        userRating.setUserRating(ratingList);
        return  userRating;
    }
}
