package com.example.movie_watchlist;

import com.example.movie_watchlist.controllers.MovieController;
import com.example.movie_watchlist.models.Director;
import com.example.movie_watchlist.models.Genre;
import com.example.movie_watchlist.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class MovieWatchlistApplicationTests {

	@Autowired
	MovieController movieController;

	@BeforeEach
	public void setup(){
		movieController.addMovie(new Movie("M1",7.0,100, Genre.ACTION));
		movieController.addMovie(new Movie("M2",8.0,120,Genre.ACTION));
		movieController.addMovie(new Movie("M3",9.0,140,Genre.ACTION));

		movieController.addDirector(new Director("D1",0,4.0));

		movieController.addMovieDirectorPair("M1","D1");
		movieController.addMovieDirectorPair("M2","D1");
	}

	@Test
	public void testAddMovie(){

		Movie movie = new Movie("Dunki",8.2,147,Genre.DRAMA);

		ResponseEntity<String> response = movieController.addMovie(movie);
		ResponseEntity<Movie> movieResponse = movieController.getMovieByName("Dunki");

		if(Objects.nonNull(movieResponse)){
			assertEquals(8.2,movieResponse.getBody().getImdbRating());
		}else {
			assertEquals(8.2,null);
		}
	}

	@Test
	public void testAddDirector(){

		Director director = new Director("Raju Hirani",6,9.5);

		ResponseEntity<String> response = movieController.addDirector(director);
		ResponseEntity<Director> directorResponse = movieController.getDirectorByName("Raju Hirani");

		if(Objects.nonNull(directorResponse)){
			assertEquals("Raju Hirani",directorResponse.getBody().getName());
		}else {
            assertEquals(9.5,null);
		}
	}

	@Test
	public void testGetMoviesByDirectorName(){

		ResponseEntity<List<Movie>> result = movieController.getMoviesByDirectorName("D1");

		if(result.getBody().equals(null)){
			assertEquals(true,false);
		}else {
			List<Movie> results = result.getBody();
			assertEquals(results.size(),2);
		}

	}

}
