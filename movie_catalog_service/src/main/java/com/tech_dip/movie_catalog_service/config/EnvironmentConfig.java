package com.tech_dip.movie_catalog_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource({ "classpath:application-${spring.profiles.active}.properties" })
@Configuration

public class EnvironmentConfig {

    @Value("${movie.catalog.service.url}")
    private  String movieCatalogService;

    @Value("${movie.data.service.url}")
    private  String movieInfoService;

    @Value("${movie.rating.service.url}")
    private  String movieRatingService;


    public String getMovieCatalogService() {
        return movieCatalogService;
    }

    public void setMovieCatalogService(String movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    public String getMovieInfoService() {
        return movieInfoService;
    }

    public void setMovieInfoService(String movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    public String getMovieRatingService() {
        return movieRatingService;
    }

    public void setMovieRatingService(String movieRatingService) {
        this.movieRatingService = movieRatingService;
    }
}
