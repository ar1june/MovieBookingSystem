package com.arjun.MovieBookingSystem.services;

import com.arjun.MovieBookingSystem.entities.Movie;
import com.arjun.MovieBookingSystem.exceptions.MovieDetailNotFoundException;

import java.util.List;

/**
 * This interface will define methods supported by
 * MovieService
 */

public interface MovieService {
    /**
     * It should be able to take a movie request and
     * save it to database
     */
    public Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details
     * based on movie id
     */
    public Movie getMovieDetails(int id) throws MovieDetailNotFoundException;

    /**
     * I want to update the details of existing movie
     */

    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailNotFoundException;

    /**
     * Delete a movie
     */
    public boolean deleteMovie(int id) throws MovieDetailNotFoundException;

    /**
     * I want to get the list of all movies present
     */
    public List<Movie> getAllMoviesDetails();

}
