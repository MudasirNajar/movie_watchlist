package com.example.movie_watchlist.repository;

import com.example.movie_watchlist.models.Director;
import com.example.movie_watchlist.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, String> movieDirectorPair = new HashMap<>();

    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String pairMovieDirector(String movieName, String directorName) {
        movieDirectorPair.put(movieName, directorName);
        return "Connected them successfully";
    }


    public List<Movie> getMovies() {
        return movieDb.values().stream().toList();
    }

    public List<Director> getDirectors() {
        return directorDb.values().stream().toList();
    }

    public List<Movie> findListOfMovies(String directorName) {

        List<Movie> movies = new ArrayList<>();

        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                for (Movie movie : movieDb.values()) {
                    if (movie.getName().equals(movieName)) {
                        movies.add(movie);
                    }
                }
            }
        }
        return movies;
    }

    public String removeDirector(String directorName) {
        //Director needs to be deleted in directorDb,movieDirectorPair

        directorDb.remove(directorName);

        //Iterate the complete HashMap to delete movieDirectorPair

        for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "Director removed successfully";
    }

    public String deleteEverything() {
        for (String directorName : directorDb.keySet()) {
            directorDb.remove(directorName);

            for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
                if (entry.getValue().equals(directorName)) {
                    String movieName = entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return "All directors deleted";
    }

}
