package com.tech_dip.movie_catalog_service.service;

import com.tech_dip.movie_catalog_service.config.CustomException;
import com.tech_dip.movie_catalog_service.config.EnvironmentConfig;
import com.tech_dip.movie_catalog_service.modal.MovieCatalog;
import com.tech_dip.movie_catalog_service.modal.Movies;
import com.tech_dip.movie_catalog_service.modal.Rating;
import com.tech_dip.movie_catalog_service.modal.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EnvironmentConfig environmentConfig;

    public UserRating getMovieRatingList (int userId) {
        try {
            UserRating userRating =restTemplate.getForObject(environmentConfig.getMovieRatingService()+"/api/v1/movie-rating/user/"+userId, UserRating.class);
            return  userRating;
        } catch (Exception ex) {
            throw  new CustomException("exception occur : "+ex.getMessage());
        }

    }

    public MovieCatalog getMovieDetails (int movieId) {
            MovieCatalog movieCatalog = restTemplate.getForObject(environmentConfig.getMovieInfoService() + "/api/v1/movie_info/movies/" + movieId, MovieCatalog.class);
            return movieCatalog;
    }

    public Movies addMovies(Movies movies) {
        try {
            Movies moviesAdded =restTemplate.postForObject(environmentConfig.getMovieInfoService()+"/api/v1/movie_info/movies",movies ,Movies.class);
            return  moviesAdded;
        } catch (Exception ex) {
            throw  new CustomException("exception occur : "+ex.getMessage());
        }

    }


}
