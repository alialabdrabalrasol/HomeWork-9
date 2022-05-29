package com.example.homework09.controller;

import com.example.homework09.model.Movie;
import com.example.homework09.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }
    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie, Errors error){
        if(error.hasFieldErrors()){
            String err_msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(err_msg);
        }
        movieService.addMovies(movie);
        return ResponseEntity.status(201).body("Movie added");
    }
    @PutMapping("{id}")
    public ResponseEntity updateMovie(@RequestBody @Valid Movie movie, @PathVariable String id, Errors error){
        if(error.hasFieldErrors()){
            String err_msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(err_msg);
        }
        movieService.updateMovie(movie,id);
        return ResponseEntity.status(201).body("Movie updated");

    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie Deleted");
    }
}
