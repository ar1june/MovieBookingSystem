package com.arjun.MovieBookingSystem;

import com.arjun.MovieBookingSystem.dao.MovieDao;
import com.arjun.MovieBookingSystem.dao.StatusDao;
import com.arjun.MovieBookingSystem.entities.Movie;
import com.arjun.MovieBookingSystem.entities.Status;
import com.arjun.MovieBookingSystem.services.InitService;
import com.arjun.MovieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

//		MovieDao movieDao = ctx.getBean(MovieDao.class);
//		System.out.println(movieDao);
//
//		// I should be able to save the entity
//
//		System.out.println("========= Creating Movie Object ===========");
//		Movie movie = new Movie();
//		movie.setMovieName("Krrish");
//		movie.setMovieDescription("Awesome movie");
//		movie.setReleaseDate(LocalDateTime.of(2014, 4, 26, 2, 2));
//		movie.setDuration(150);
//		movie.setCoverPhotoUrl("cover-photo-url");
//		movie.setTrailerUrl("trailer-url");
//
//		System.out.println("Movie object before storage : " +  movie);
//
//		System.out.println("###### Going to save now in DB #######");
//
//		Movie savedObject = movieDao.save(movie);
//
//		System.out.println("Saved Object : " + savedObject);
//
//		/**
//		 * I should able to find movie I am interested in
//		 */
//
//		Movie searchedMovie = movieDao.findById(1).get();
//
//		System.out.println("Searched Movie : " + searchedMovie);
//
//		movie.setMovieDescription("Updated Description");
//
//		movieDao.save(movie);
//
//		/**
//		 * I want to delete the movie
//		 */
//
//		List<Movie> result = movieDao.findByMovieName("Krrish");
//		System.out.println(result);
////		movieDao.delete(searchedMovie);

		//----------------------------------------------------//
//		MovieService movieService = ctx.getBean(MovieService.class);
//
//		StatusDao statusDao = ctx.getBean(StatusDao.class);
//
//		Status status = new Status();
//		status.setStatusName("Released");
//
//		/**
//		 * Save the status
//		 */
//		statusDao.save(status);
//
//		Movie movie = new Movie();
//		movie.setMovieDescription("Good Movie");
//		movie.setMovieName("Arjun Reddy");
//		movie.setTrailerUrl("Trailer-url");
//		movie.setDuration(120);
//		movie.setReleaseDate(LocalDateTime.of(2021, 1,1,1,1));
//		movie.setCoverPhotoUrl("cover-photo-url");
//		movie.setStatus(status);
//		movieService.acceptMovieDetails(movie);
	}

	/**
	 *  This a way to execute something in the very beginning when
	 *  application is starting up
	 */

	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			System.out.println("This will be executed when the app is starting");
			initService.init();
		};
	}

	/**
	 * This will store the manually created object as a bean in spring
	 * container
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
