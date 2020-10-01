package com.tech_dip.movie_rating_service.controller;

import com.tech_dip.movie_rating_service.modal.Rating;
import com.tech_dip.movie_rating_service.modal.UserRating;
import com.tech_dip.movie_rating_service.services.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie-rating")
public class MovieRatingController {

    @Autowired
    MovieRatingService movieRatingService;

    @GetMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") int userId) {
        return movieRatingService.getRatingList(userId);
    }
}
