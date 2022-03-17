package com.arjun.MovieBookingSystem.services.impl;

import com.arjun.MovieBookingSystem.dao.*;
import com.arjun.MovieBookingSystem.entities.City;
import com.arjun.MovieBookingSystem.entities.Movie;
import com.arjun.MovieBookingSystem.entities.Status;
import com.arjun.MovieBookingSystem.entities.UserType;
import com.arjun.MovieBookingSystem.services.CityService;
import com.arjun.MovieBookingSystem.services.InitService;
import com.arjun.MovieBookingSystem.services.MovieService;
import com.arjun.MovieBookingSystem.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {


    public InitServiceImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    private CityService cityService;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private StatusService statusService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TheatreDao theatreDao;

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private BookingDao bookingDao;

    /**
     *  Cooking Data
     *
     *  Define and initialize together
     *
     *
     */

    List<Status> statuses = Arrays.asList(new Status("UPCOMING"), new Status("RELEASED"),new Status("BLOCKED"));


    @Override
    public void init() {
        /**
         *  Write the logic to store the data in DB in different tables
         */

        /**
         *  Add cities
         */
        createCities();

        /**
         *  Add User Types
         */
        createUserTypes();

        /**
         *  Add Statuses
         */
        createStatuses();

        /**
         *  Add Movies
         */

        createMovies();

        /**
         *  Add costumers
         */

        /**
         *  Add theatres
         */

        /**
         *  Bookings
         */
    }

    private void createMovies() {
        Movie movie1 = new Movie();
        movie1.setMovieName("Movie1_name");
        movie1.setTrailerUrl("Movie1-url");
        movie1.setStatus(statuses.get(1));
        movie1.setMovieDescription("Movie1 description");
        movie1.setDuration(120);
        movie1.setReleaseDate(LocalDateTime.of(2020,2,2,2,2));
        movie1.setCoverPhotoUrl("url");

        movieService.acceptMovieDetails(movie1);
    }

    private void createStatuses() {


        statuses.forEach(status -> {
            statusService.acceptStatusDetails(status);
        });
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Costumer"));
        userTypes.add(new UserType("Admin"));

        userTypes.forEach(userType -> {userTypeDao.save(userType);});
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Patna"));
        cities.add(new City("Delhi"));
        cities.add(new City("Bengaluru"));
        cities.add(new City("Pune"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }


}
