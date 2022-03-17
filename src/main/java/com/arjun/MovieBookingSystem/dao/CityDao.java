package com.arjun.MovieBookingSystem.dao;

import com.arjun.MovieBookingSystem.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
    public City findByCityName(String cityName);
}
