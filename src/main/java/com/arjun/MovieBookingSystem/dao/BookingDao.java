package com.arjun.MovieBookingSystem.dao;

import com.arjun.MovieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {
}
