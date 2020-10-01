package com.tech_dip.movie_data_service.controller;

import com.tech_dip.movie_data_service.modal.MovieInfo;
import com.tech_dip.movie_data_service.modal.Movies;
import com.tech_dip.movie_data_service.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie_info")
public class MovieInfoController {



    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping("/movie/{movieId}")
    public Movies getMovieDetail(@PathVariable("movieId") int movieId) {
        return movieInfoService.getMovieDetail(movieId);


    }
}
