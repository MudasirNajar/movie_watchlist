package com.example.movie_watchlist.service;

import com.example.movie_watchlist.models.Director;
import com.example.movie_watchlist.models.Movie;
import com.example.movie_watchlist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String pairMovieDirector(String movieName, String directorName) {
        return movieRepository.pairMovieDirector(movieName, directorName);
    }


    public Movie getMovieByName(String name) {
        List<Movie> movies = movieRepository.getMovies();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name) {
        List<Director> directors = movieRepository.getDirectors();
        for (Director director : directors) {
            if (director.getName().equals(name)) {
                return director;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        return movieRepository.findListOfMovies(directorName);
    }

    public String removeDirector(String directorName) {
        return movieRepository.removeDirector(directorName);
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteEverything();
    }

    public List<Movie> findAllMovies() {
        return movieRepository.getMovies();
    }

}
