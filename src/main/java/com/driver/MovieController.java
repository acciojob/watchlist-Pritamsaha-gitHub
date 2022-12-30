package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController//This is a controller layer
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    //add a movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String resultMovie=movieService.addmov(movie);
        return new ResponseEntity<>(resultMovie, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody() Director director){
        String resultDirector=movieService.adddir(director);
        return new ResponseEntity<>(resultDirector,HttpStatus.CREATED);
    }
    //add movie director pair
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestBody() String moviename,String directorname){
        String result=movieService.addMoviedirector(moviename,directorname);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    //get movie by name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable("name") String name ){
        //Movie result=movieService.getMoviebyName(name);
        return new ResponseEntity<>(movieService.getMoviebyName(name),HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable("name") String name){
        Director result=movieService.getDirectorbyName(name);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    //get movies of a director
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.addmoviebyDirector(director),HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String director){
        String result=movieService.deleteDirectorbyName(director);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deletealldirectors(),HttpStatus.CREATED);
    }
}
