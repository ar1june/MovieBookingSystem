package com.arjun.MovieBookingSystem.dao;

import com.arjun.MovieBookingSystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
