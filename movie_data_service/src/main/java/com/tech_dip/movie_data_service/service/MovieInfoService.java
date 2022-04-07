package com.tech_dip.movie_data_service.service;
import com.tech_dip.movie_data_service.modal.Movies;
import com.tech_dip.movie_data_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieInfoService {

    @Autowired
    private MovieRepository movieRepository;

    public Movies addMovies (Movies movies) {

        return movieRepository.save(movies);
}

    public Movies getMovieById(long id) {

        return movieRepository.findById(id).orElseThrow( () -> new NullPointerException("movie not found  for " + id));
    }

    public List<Movies> getAllMovie() {
        List<Movies> movieList =  movieRepository.findAll();
        return movieList;
    }

    public Movies updateMovies(Long movieId,Movies movies) {
        Movies data = movieRepository.findById(movieId)
                .orElseThrow(() -> new NullPointerException("movie not found for this id :: " + movies));
        data.setMovieName(movies.getMovieName());
        final Movies updatedmovie = movieRepository.save(data);
        return updatedmovie;
    }

    public  void deleteMovie(Long id) {
        Movies movies = movieRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Movie not found" + id));
        movieRepository.delete(movies);
        System.out.println("deleted movie :" +id);
    }
}
