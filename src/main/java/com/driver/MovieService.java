package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//This is a service layer
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    //add a movie
    public String addmov(Movie movie){
        String resultMovie=movieRepository.addmov(movie);
        return resultMovie;
    }
    public String adddir(Director director){
        String resultDir=movieRepository.addDir(director);
        return resultDir;
    }
    public Movie getMoviebyName( String name){
        Movie resultdb=movieRepository.getMovieByName(name);
        return resultdb;
    }
    public Director getDirectorbyName(String name){
        Director resultdb=movieRepository.getDiectorbyName(name);
        return resultdb;
    }
    public String addMoviedirector(String moviename,String directorname){
        String result=movieRepository.adddirectormoviepair(moviename,directorname);
        return result;
    }
    public List<String> addmoviebyDirector(String director){
        return movieRepository.getMoviesbydirectorName(director);

    }
    public List<String> findAllMovies(){
        return movieRepository.findAllmovies();
    }
    public String deleteDirectorbyName(String director){
        String result=movieRepository.deleteDirectorByname(director);
        return result;
    }
    public String deletealldirectors(){
        return movieRepository.deleteAlldirectors();
    }
}
