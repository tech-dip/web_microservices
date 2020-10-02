package com.tech_dip.movie_catalog_service.controller;


import com.netflix.discovery.EurekaClient;
import com.tech_dip.movie_catalog_service.modal.MovieCatalog;
import com.tech_dip.movie_catalog_service.modal.Rating;
import com.tech_dip.movie_catalog_service.modal.ResponseDto;
import com.tech_dip.movie_catalog_service.modal.UserRating;
import com.tech_dip.movie_catalog_service.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movie-catalog")
public class MovieCatalogController {

    @Autowired
    MovieCatalogService movieCatalogService;

    @GetMapping(value = "/user/{userId}" ,produces = "application/json")
    public ResponseDto getMovieCatalog (@PathVariable("userId") int userId) {

        // call for first Service  to get movie rating based on userId
        UserRating userRating = movieCatalogService.getMovieRatingList(userId);
        List<MovieCatalog> movieCatalogsList =  userRating.getUserRating().stream().map(rating-> {
            // call for second  Service  to get movie Detail based on movieId
               MovieCatalog movieCatalog = movieCatalogService.getMovieDetails(rating.getMovieId());
               return  new MovieCatalog(movieCatalog.getMovieName(),movieCatalog.getDescription(),rating.getTotalRating());

       }).collect(Collectors.toList());
        return  new ResponseDto(200,movieCatalogsList,"Success");
    }

}
