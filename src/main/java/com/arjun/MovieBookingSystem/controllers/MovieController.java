package com.arjun.MovieBookingSystem.controllers;

import com.arjun.MovieBookingSystem.dtos.MovieDTO;
import com.arjun.MovieBookingSystem.entities.Movie;
import com.arjun.MovieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.arjun.MovieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  End Point
 *  root path -> mbs/v1 | sorted
 *  127.0.0.1:8080/mbs/v1/movies
 */

@RestController
/**
 *  1. @Component
 *  2. Gives hint to spring that whenever a REST call comes
 *  make sure this class is informed
 *
 */
@RequestMapping("/movies")
/**
 *  127.0.0.1:8080/mbs/v1/movies
 */
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     *  We need to define the bean of ModelMapper first
     */
    @Autowired
    private ModelMapper modelMapper;



    /**
     *  GET 127.0.0.1:8080/mbs/v1/movies/greetings
     *
     *  Hello People
     */
    @GetMapping("/greetings")
    public ResponseEntity helloWorld() {
        return new ResponseEntity("Hello People", HttpStatus.OK);
    }

    /**
     *  Get all the movies
     *
     *  GET 127.0.0.1:8080/mbs/v1/movies
     */

    @GetMapping
    public ResponseEntity getALLMovies() {
        /**
         *  First get all the movies
         */
        List<Movie> movies = movieService.getAllMoviesDetails();

        List<MovieDTO> movieDTOS = new ArrayList<>();

        for (Movie movie : movies) {
            movieDTOS.add(convertToMovieDTO(movie));
        }

        /**
         *  Wrap inside the ResponseEntity
         */
        return new ResponseEntity(movieDTOS, HttpStatus.OK);

    }

    /**
     *  Get movie details based on the id
     *
     *  Get 127.0.0.1:8080:mbs/v1/movies/{movie_id}
     *
     */
    @GetMapping(value = "/{movieId}")
    public ResponseEntity getMovieBasedOnId(
            @PathVariable(name = "movieId") int movieId) throws MovieDetailNotFoundException {
        Movie movie = null;

        try {
            movie = movieService.getMovieDetails(movieId);
        } catch (MovieDetailNotFoundException e) {
            return new ResponseEntity("MovieId : [ " + movieId + " ] passed is not correct",
                    HttpStatus.BAD_REQUEST);
        }

        /**
         *  Convert the movie object to MovieDTO objects
         */
        MovieDTO movieDTO = convertToMovieDTO(movie);

        return new ResponseEntity(movieDTO, HttpStatus.OK);

    }

    /**
     *  I want to create a new movie
     *
     *  POST 127.0.0.1:8080/mbs/v1/movies
     *
     *  This method expects some request body
     *
     * @param movie
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) {
        // I need to create the movie
        // I need to create movie object from movieDTO object
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        // Again I need to convert it back to send back to Client

        MovieDTO responseBody = modelMapper.map(savedMovie, MovieDTO.class);

        return new ResponseEntity(responseBody, HttpStatus.CREATED);


    }

    /**
     * I would like to update an already existing movie
     *
     * PUT 127.0.0.1:8080/mbs/v1/movies/{movieId}
     * @param movie
     * @return
     */

    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,@PathVariable(name = "movieId") int movieId) throws MovieDetailNotFoundException {

        /**
         *  First check if the movie is present or not
         */
        Movie storedMovie = movieService.getMovieDetails(movieId);

        Movie movieToBeUpdated = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.updateMovieDetails(movieId, movieToBeUpdated);

        MovieDTO savedResponse = modelMapper.map(savedMovie, MovieDTO.class);

        return new ResponseEntity(savedResponse, HttpStatus.ACCEPTED);

    }

    /**
     * DELETE 127.0.0.1:8080/mbs/v1/movies/{movieId}
     * @param movie
     * @return
     */

    @DeleteMapping(value = "/{movieId")
    public ResponseEntity deleteMovie(@PathVariable(name = "movieId") int id) throws MovieDetailNotFoundException {

        movieService.deleteMovie(id);

        return new ResponseEntity<>("DELETED", HttpStatus.OK);

    }

    private MovieDTO convertToMovieDTO(Movie movie) {

        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

//        MovieDTO movieDTO = new MovieDTO();
//        movieDTO.setMovieId(movie.getMovieId());
//        movieDTO.setMovieDescription(movie.getMovieDescription());
//        movieDTO.setMovieName(movie.getMovieName());
//        movieDTO.setDuration(movie.getDuration());
//        movieDTO.setTrailerUrl(movie.getTrailerUrl());
//        movieDTO.setCoverPhotoUrl(movie.getCoverPhotoUrl());
//        movieDTO.setReleaseDate(movie.getReleaseDate());
//        movieDTO.setStatusId(movie.getStatus().getStatusId());
        return movieDTO;

    }
}
