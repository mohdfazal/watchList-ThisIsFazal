package com.example.watchList_ThisIsFazal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        String ans = movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(Director director) {
        String ans = movieRepository.addDirector(director);
        return ans;
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);
        return ans;
    }

    public Movie getMovieByName(String movieName){
//        Movie movie = movieRepository.movieDb.get(movieName);
        for (Movie movie : movieRepository.movieDb.values()){
            if(movie.getName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String directorName){

        for (Director director : movieRepository.directorDb.values()){
            if(director.getName().equals(directorName)){
                return director;
            }
        }
        return null;
    }


    public List<Movie> getMoviesByDirectorName(String directorName){
        List<Movie> movieList = movieRepository.getMoviesByDirectorName(directorName);
        return movieList;
    }

    public String deleteDirectorAndItsNovieByDirectorName(String directorName){
        String ans = movieRepository.deleteDirectorAndItsMovieByDirectorName(directorName);
        return ans;
    }

    public String deleteEverything(){
        String ans = movieRepository.deleteEverything();
        return ans;
    }
}
