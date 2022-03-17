package com.arjun.MovieBookingSystem.services.impl;

import com.arjun.MovieBookingSystem.dao.MovieDao;
import com.arjun.MovieBookingSystem.entities.Movie;
import com.arjun.MovieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.arjun.MovieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    /**
     * To talk with the database, I need the help
     * of MovieDao
     */
    @Autowired
    private MovieDao movieDao;
    @Override
    public Movie acceptMovieDetails(Movie movie) {
        /**
         * With the help of MovieDao save into db
         */
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailNotFoundException {
        /**
         *  Fetch the movie details based on the Id
         */
        return movieDao.findById(id).orElseThrow(() -> new MovieDetailNotFoundException("Movie not found" + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailNotFoundException {
        /**
         *  Update the movie
         */
        Movie savedMovie = movieDao.findById(id).orElseThrow(() -> new MovieDetailNotFoundException("Movie not found" + id));

        /**
         * Read the attributes from the movie object and update it in savedMovie
         */

        if(movie.getMovieName()!=null) {
            savedMovie.setMovieName(movie.getMovieName());
        }

        if(movie.getMovieDescription()!=null) {
            savedMovie.setMovieDescription((movie.getMovieDescription()));
        }

        if(isNotNullOrZero(movie.getDuration())) {
            savedMovie.setDuration(movie.getDuration());
        }

        if(isNotNullOrZero(movie.getCoverPhotoUrl())) {
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }

        if(isNotNullOrZero(movie.getTrailerUrl())) {
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }

        if(isNotNullOrZero(movie.getReleaseDate())) {
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        if(isNotNullOrZero(movie.getStatus())) {
            savedMovie.setStatus(movie.getStatus());
        }

        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj) {
          return obj!=null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDao.findAll();
    }
}
