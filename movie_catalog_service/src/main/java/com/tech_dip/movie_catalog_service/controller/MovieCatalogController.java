package com.tech_dip.movie_catalog_service.controller;


import com.netflix.discovery.EurekaClient;
import com.tech_dip.movie_catalog_service.config.CustomException;
import com.tech_dip.movie_catalog_service.modal.*;
import com.tech_dip.movie_catalog_service.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movie-catalog")
public class MovieCatalogController {

    @Autowired
    MovieCatalogService movieCatalogService;

    @PostMapping(value = "/movies" )
    public ResponseEntity<Movies> createMovies(@RequestBody Movies movies) {
        // call to movie_info_service to add movies
            Movies moviesAdded = movieCatalogService.addMovies(movies);
            return  new ResponseEntity(moviesAdded,HttpStatus.OK);
        }


    @GetMapping(value = "/user/{userId}" ,produces = "application/json")
    public ResponseEntity<List<MovieCatalog>> getMovieCatalog (@PathVariable("userId") int userId) throws  Exception {
        try {
            // call for first Service  to get movie rating based on userId
            UserRating userRating = movieCatalogService.getMovieRatingList(userId);
            List<MovieCatalog> movieCatalogsList = userRating.getUserRating().stream().map(rating -> {
                // call for second  Service  to get movie Detail based on movieId
                MovieCatalog movieCatalog = movieCatalogService.getMovieDetails(rating.getMovieId());
                return new MovieCatalog(movieCatalog.getMovieName(), movieCatalog.getDescription(), rating.getTotalRating());

            }).collect(Collectors.toList());
            return new ResponseEntity(movieCatalogsList, HttpStatus.OK);
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }

}
