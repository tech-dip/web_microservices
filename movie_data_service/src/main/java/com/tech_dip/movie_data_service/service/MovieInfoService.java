package com.tech_dip.movie_data_service.service;
import com.tech_dip.movie_data_service.modal.MovieInfo;
import com.tech_dip.movie_data_service.modal.Movies;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieInfoService {

    public Movies getMovieDetail(int movieId) {
        List<Movies> movieList= Arrays.asList(new Movies(1,"Avenger","A HollyWood Movie"),new Movies(2,"Bahubali","A BollyWood Movie"),new Movies(3,"Iron Man","A HollyWood Movie"));
         Movies movie = movieList.stream().filter((movies) -> movies.getId() == movieId).findAny().get();
            return movie;
    }
}
