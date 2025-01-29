package com.example.watchList_ThisIsFazal;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    // HashMap to store movies, with movie name as the key
    HashMap<String, Movie> movieDb = new HashMap<>();

    // HashMap to store directors, with director name as the key
    HashMap<String , Director> directorDb = new HashMap<>();

    // HashMap to store movie-director pairs, with movie name as the key and director name as the value
    HashMap<String , String> movieDirectorPairDb = new HashMap<>();


//     * Adds a movie to the database.
//     * @param movie Movie object containing name, duration, and IMDb rating.
//     * @return Success message.

    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie); // Store the movie object in the HashMap
        return "Movie added successfully";
    }


//     * Adds a director to the database.
//     * @param director Director object containing name, number of movies, and IMDb rating.
//     * @return Success message.

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director); // Store the director object in the HashMap
        return "Director added successfully";
    }


//     * Pairs an existing movie with an existing director.
//     * @param movieName Name of the movie.
//     * @param directorName Name of the director.
//     * @return Success message.

    public String addMovieDirectorPair(String movieName, String directorName) {
        movieDirectorPairDb.put(movieName, directorName); // Map movie to director
        return "Movie and Director have been paired successfully";
    }


//     * Retrieves a list of movies directed by a given director.
//     * @param directorName Name of the director.
//     * @return List of Movie objects directed by the given director.

    public List<Movie> getMoviesByDirectorName(String directorName) {
        List<Movie> movieList = new ArrayList<>(); // Create an empty list to store the movies

        // Iterate through movie-director mapping to find movies by the director
        for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
            if (entry.getValue().equals(directorName)) { // Check if the movie is directed by the given director
                String movieName = entry.getKey(); // Get the movie name
                Movie movie = movieDb.get(movieName); // Fetch movie details from movieDb
                movieList.add(movie); // Add to the result list
            }
        }
        return movieList; // Return the list of movies
    }


//     * Deletes a director and all movies associated with them.
//     * @param directorName Name of the director to delete.
//     * @return Success message.

    public String deleteDirectorAndItsMovieByDirectorName(String directorName) {
        directorDb.remove(directorName); // Remove the director from directorDb

        // Iterate through movie-director pairs to find movies associated with the director
        List<String> moviesToRemove = new ArrayList<>();
        for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
            if (entry.getValue().equals(directorName)) { // If the movie belongs to the director
                moviesToRemove.add(entry.getKey()); // Store the movie name for later removal
            }
        }

        // Remove movies and their mapping from both databases
        for (String movieName : moviesToRemove) {
            movieDb.remove(movieName); // Remove the movie from movieDb
            movieDirectorPairDb.remove(movieName); // Remove the mapping from movieDirectorPairDb
        }

        return "Director and all their movies have been deleted successfully";
    }


//     * Deletes all directors and their associated movies.
//     * Movies without any director association are not deleted.
//     * @return Success message.

    public String deleteEverything() {
        for (String directorName : new ArrayList<>(directorDb.keySet())) {
            // Remove the director from directorDb
            directorDb.remove(directorName);

            // Find and remove all movies directed by the current director
            List<String> moviesToRemove = new ArrayList<>();
            for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
                if (entry.getValue().equals(directorName)) {
                    moviesToRemove.add(entry.getKey());
                }
            }

            // Remove all movies directed by this director
            for (String movieName : moviesToRemove) {
                movieDb.remove(movieName);
                movieDirectorPairDb.remove(movieName);
            }
        }
        return "All directors and their movies have been deleted successfully";
    }
}
