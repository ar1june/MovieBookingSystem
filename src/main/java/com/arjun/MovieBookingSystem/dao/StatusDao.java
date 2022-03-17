package com.arjun.MovieBookingSystem.dao;

import com.arjun.MovieBookingSystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
    public Status findByStatusName(String statusName);
}

