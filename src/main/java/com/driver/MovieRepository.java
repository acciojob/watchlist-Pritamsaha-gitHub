package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository//This is a repository layer
public class MovieRepository {

    //add databases

    private HashMap<String,Movie>movMap=new HashMap<>();
    private HashMap<String,Director>dirMap=new HashMap<>();
    private HashMap<String, List<String>>movdirmap=new HashMap<>();

    //add amovie
    public String addmov(Movie movie){
        String key=movie.getName();
        movMap.put(key,movie);
        return "Movie sucessfully Added";
    }
    //add director
    public String addDir(Director director){
        String key=director.getName();
        dirMap.put(key,director);
        return "Director added";
    }
    public Movie getMovieByName(String name){
        if(movMap.containsKey(name)) return movMap.get(name);
        else return null;
    }
    public Director getDiectorbyName(String name){
        if(dirMap.containsKey(name)) return dirMap.get(name);
        else return null;
    }
    public String adddirectormoviepair( String moviename,String directorname){
        if(movMap.containsKey(moviename) && dirMap.containsKey(directorname)){
            List<String>currentMovies=new ArrayList<>();
            if (movdirmap.containsKey(directorname)){
                currentMovies=movdirmap.get(directorname);
            }
            currentMovies.add(moviename);
            movdirmap.put(directorname,currentMovies);
        }
        return "Movie and Director sucessfully added";
    }
    public List<String> getMoviesbydirectorName(String director){
        List<String>ans=new ArrayList<>();
        if(movdirmap.containsKey(director)) ans=movdirmap.get(director);
        return ans;
    }
    public List<String>findAllmovies(){
        return new ArrayList<>(movMap.keySet());
    }
    public String deleteDirectorByname(String director){
        //delete from movdirmap
        if(movdirmap.containsKey(director)){
            List<String>deletelist=new ArrayList<>();
            deletelist=movdirmap.get(director);
            for(int i=0;i<deletelist.size();i++){
                movMap.remove(deletelist.get(i));
            }
        }
        //delete from movMap
        movdirmap.remove(director);
        //delete from dirMap
        if(dirMap.containsKey(director)) dirMap.remove(director);
        return "Sucessfully Deleted";
    }
    public String deleteAlldirectors(){
        movMap=new HashMap<>();
        dirMap=new HashMap<>();
        movdirmap=new HashMap<>();
        return "Sucessfully all deleted";
    }
}
