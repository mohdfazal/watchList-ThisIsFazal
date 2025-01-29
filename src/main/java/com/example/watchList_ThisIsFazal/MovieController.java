package com.example.watchList_ThisIsFazal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/movies") // Base URL for all endpoints in this controller
public class MovieController {

    @Autowired
    MovieService movieService; // Injecting MovieService to handle business logic

    @PostMapping("/add-movie") // Endpoint to add a new movie
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED); // Return HTTP 201 (Created)
    }

    @PostMapping("/add-director") // Endpoint to add a new director
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED); // Return HTTP 201 (Created)
    }

    @PutMapping("/add-movie-director-pair") // Endpoint to pair a movie with a director
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                       @RequestParam("directorName") String directorName) {
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED); // Return HTTP 201 (Created)
    }

    @GetMapping("/getMovieByName") // Endpoint to get movie details by name
    public ResponseEntity<Movie> getMovieByName(@RequestParam("movieName") String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.FOUND); // Return HTTP 302 (Found)
    }

    @GetMapping("/getDirectorByName") // Endpoint to get director details by name
    public ResponseEntity<Director> getDirectorByName(@RequestParam("directorName") String directorName) {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.FOUND); // Return HTTP 302 (Found)
    }

    @GetMapping("/get-movies-by-director-name") // Endpoint to get movies directed by a given director
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@RequestParam("directorName") String directorName) {
        List<Movie> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList, HttpStatus.FOUND); // Return HTTP 302 (Found)
    }

    @DeleteMapping("/delete-director-by-name") // Endpoint to delete a director and their movies
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName) {
        String ans = movieService.deleteDirectorAndItsNovieByDirectorName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.GONE); // Return HTTP 410 (Gone)
    }

    @DeleteMapping("/delete-all-directors") // Endpoint to delete all directors and their movies
    public ResponseEntity<String> deleteEverything() {
        String ans = movieService.deleteEverything();
        return new ResponseEntity<>(ans, HttpStatus.GONE); // Return HTTP 410 (Gone)
    }
}
