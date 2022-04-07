package com.tech_dip.movie_data_service.controller;

import com.tech_dip.movie_data_service.modal.MovieInfo;
import com.tech_dip.movie_data_service.modal.Movies;
import com.tech_dip.movie_data_service.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie_info")
public class MovieInfoController {
    @Autowired
    private MovieInfoService movieInfoService;

    @PostMapping("/movies")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movies) {
        Movies  result = movieInfoService.addMovies(movies);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @GetMapping("movies/{movieId}")
    @Cacheable(value = "movies",key = "#movieId")
    public Movies getMovieById(@PathVariable("movieId") long movieId) {
        try {
            System.out.println("getting data from DB for id " + movieId);
            return movieInfoService.getMovieById(movieId);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @GetMapping("/movies")
    public List<Movies> getAllMovies() {
        System.out.println("getting data from DB");
       return movieInfoService.getAllMovie();
    }

    @PutMapping("/movies/{employeeId}")
    @CachePut(value = "movies")
    public Movies updateMovie(@PathVariable("employeeId") long movieId , @RequestBody Movies movies) {
        return movieInfoService.updateMovies(movieId,movies);
    }

    @DeleteMapping("movies/{id}")
    @CacheEvict(value = "movies", allEntries = true)
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") long movieId) {
       movieInfoService.deleteMovie(movieId);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }

}
