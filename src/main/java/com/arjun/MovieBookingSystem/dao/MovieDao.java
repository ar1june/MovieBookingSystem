package com.arjun.MovieBookingSystem.dao;

import com.arjun.MovieBookingSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    /**
     * I also want to support search by Movie Name
     */

    public List<Movie> findByMovieName(String movieName);

    /**
     * I want to query based on multiple columns
     */

    public List<Movie> findByMovieNameAndDuration(String moviename, int duration);

    /**
     * Find movie with duration greater than given hour
     */
    public List<Movie> findByReleaseDateBetween(LocalDateTime start, LocalDateTime end);
    public List<Movie> findByDurationGreaterThanEqual(int duration);
    public List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);
    public List<Movie> findByMovieNameContaining(String movieName);
    public List<Movie> findByMovieNameIgnoreCase(String movieName);
}
