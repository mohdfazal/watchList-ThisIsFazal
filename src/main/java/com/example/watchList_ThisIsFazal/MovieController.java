package com.example.watchList_ThisIsFazal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

//    1. Add a movie: POST/movies/add-movie
//       Pass the Movie object as request body
//       Return success message wrapped in a ResponseEntity object
//       Controller Name - addMovie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
    // http://localhost:8088 /movies/add-movie-director-pair?movieName=Inception&directorName=Christopher%20Nolan
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                       @RequestParam("directorName") String directorName){
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans , HttpStatus.CREATED);
    }

    @GetMapping("/getMovieByName")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("movieName") String movieName){
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    @GetMapping("/getDirectorByName")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("directorName") String directorName){
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@RequestParam("directorName") String directorName){
        List<Movie> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList, HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){
        String ans = movieService.deleteDirectorAndItsNovieByDirectorName(directorName);
        return new ResponseEntity<>(ans , HttpStatus.GONE);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteEverything(){
        String ans = movieService.deleteEverything();
        return new ResponseEntity<>(ans, HttpStatus.GONE);
    }

}
