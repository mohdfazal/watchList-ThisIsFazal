package com.example.watchList_ThisIsFazal;

import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String , Director> directorDb = new HashMap<>();
    HashMap<String , String> movieDirectorPairDb = new HashMap<>();

    public String addMovie(Movie movie){
        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully ";
    }

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        movieDirectorPairDb.put(movieName, directorName);
        return "Movie name and Director name has been paired successfully";

    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        // Step 1: Create an empty list to store movies directed by the given director
        List<Movie> movieList = new ArrayList<>();

        // Step 2: Iterate over the movie-director mapping database
        for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
            // Step 3: Check if the current movie is associated with the given director
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey(); // Get the movie name from the map

                // Step 4: Retrieve the movie object from the movie database using the movie name
                Movie movie = movieDb.get(movieName);

                // Step 5: Add the movie to the result list
                movieList.add(movie);
            }
        }

        // Step 6: Return the list of movies directed by the given director
        return movieList;
    }


    public String deleteDirectorAndItsMovieByDirectorName(String directorName) {
        // Step 1: Remove the director from the director database
        directorDb.remove(directorName);

        // Step 2: Iterate over the movie-director mapping to find movies associated with the director
        for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
            // Check if the current movie is associated with the given director
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey(); // Get the movie name

                // Step 3: Remove the movie from the movie database
                movieDb.remove(movieName);

                // Step 4: Remove the movie-director pair from the mapping database
                movieDirectorPairDb.remove(movieName);
            }
        }

        // Step 5: Return a success message
        return "Director and its movies have been deleted successfully";
    }


    public String deleteEverything(){
        for(String directorName : directorDb.keySet()){
            // Step 1: Remove the director from the director database
            directorDb.remove(directorName);

            // Step 2: Iterate over the movie-director mapping to find movies associated with the director
            for (Map.Entry<String, String> entry : movieDirectorPairDb.entrySet()) {
                // Check if the current movie is associated with the given director
                if (entry.getValue().equals(directorName)) {
                    String movieName = entry.getKey(); // Get the movie name

                    // Step 3: Remove the movie from the movie database
                    movieDb.remove(movieName);

                    // Step 4: Remove the movie-director pair from the mapping database
                    movieDirectorPairDb.remove(movieName);
                }
            }
        }
        // Step 5: Return a success message
        return "Director and its movies have been deleted successfully";
    }


}
