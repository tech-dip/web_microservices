package com.tech_dip.movie_catalog_service.service;

import com.tech_dip.movie_catalog_service.modal.MovieCatalog;
import com.tech_dip.movie_catalog_service.modal.Rating;
import com.tech_dip.movie_catalog_service.modal.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalogService {

    @Autowired
     private RestTemplate restTemplate;

    public UserRating getMovieRatingList (int userId) {
        UserRating userRating =restTemplate.getForObject("http://localhost:8082/api/v1/movie-rating/user/"+userId, UserRating.class);
        return  userRating;

    }

    public MovieCatalog getMovieDetails (int movieId) {
        MovieCatalog movieCatalog =restTemplate.getForObject("http://localhost:8083/api/v1/movie_info/movie/"+movieId, MovieCatalog.class);
        return  movieCatalog;

    }

}
