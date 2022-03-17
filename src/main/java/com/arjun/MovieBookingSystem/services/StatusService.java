package com.arjun.MovieBookingSystem.services;

import com.arjun.MovieBookingSystem.entities.Status;
import com.arjun.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


public interface StatusService {
    public Status acceptStatusDetails(Status status);
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException;
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException;
    public List<Status> getAllStatusDetails();
}
