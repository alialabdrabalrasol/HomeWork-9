package com.example.homework09.service;


import com.example.homework09.model.Movie;
import com.example.homework09.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    public void addMovies(Movie movie){
        movieRepository.save(movie);
    }
    public void updateMovie(Movie movie,String id) {
        Movie old_movie=movieRepository.findById(id).get();
        old_movie.setId(movie.getId());
        old_movie.setDuration(movie.getDuration());
        old_movie.setGenre(movie.getGenre());
        old_movie.setLaunchDate(movie.getLaunchDate());
        old_movie.setRating(movie.getRating());
        movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }


}
