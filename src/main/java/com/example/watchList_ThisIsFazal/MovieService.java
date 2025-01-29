package com.example.watchList_ThisIsFazal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    // Injecting the MovieRepository to interact with the data layer
    @Autowired
    MovieRepository movieRepository;


//     * Calls the repository method to add a movie.
//     * @param movie Movie object to be added.
//     * @return Success message.

    public String addMovie(Movie movie) {
        String ans = movieRepository.addMovie(movie);
        return ans;
    }


//     * Calls the repository method to add a director.
//     * @param director Director object to be added.
//     * @return Success message.

    public String addDirector(Director director) {
        String ans = movieRepository.addDirector(director);
        return ans;
    }


//     * Calls the repository method to pair a movie with a director.
//     * @param movieName Name of the movie.
//     * @param directorName Name of the director.
//     * @return Success message.

    public String addMovieDirectorPair(String movieName, String directorName) {
        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);
        return ans;
    }


//     * Retrieves a movie by its name.
//     * @param movieName Name of the movie.
//     * @return Movie object if found, otherwise null.

    public Movie getMovieByName(String movieName) {
        // Iterates through movieDb to find the movie by name
        for (Movie movie : movieRepository.movieDb.values()) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null; // Returns null if movie is not found
    }


//     * Retrieves a director by their name.
//     * @param directorName Name of the director.
//     * @return Director object if found, otherwise null.

    public Director getDirectorByName(String directorName) {
        // Iterates through directorDb to find the director by name
        for (Director director : movieRepository.directorDb.values()) {
            if (director.getName().equals(directorName)) {
                return director;
            }
        }
        return null; // Returns null if director is not found
    }


//     * Retrieves a list of movies directed by a specific director.
//     * @param directorName Name of the director.
//     * @return List of movies directed by the given director.

    public List<Movie> getMoviesByDirectorName(String directorName) {
        List<Movie> movieList = movieRepository.getMoviesByDirectorName(directorName);
        return movieList;
    }


//     * Deletes a director and all movies associated with them.
//     * @param directorName Name of the director.
//     * @return Success message.

    public String deleteDirectorAndItsNovieByDirectorName(String directorName) {
        String ans = movieRepository.deleteDirectorAndItsMovieByDirectorName(directorName);
        return ans;
    }


//     * Deletes all directors and their associated movies from the database.
//     * Movies without an associated director are not deleted.
//     * @return Success message.

    public String deleteEverything() {
        String ans = movieRepository.deleteEverything();
        return ans;
    }
}
