package com.arjun.MovieBookingSystem.services.impl;

import com.arjun.MovieBookingSystem.dao.StatusDao;
import com.arjun.MovieBookingSystem.entities.Status;
import com.arjun.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import com.arjun.MovieBookingSystem.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    public StatusDao statusDao;

    @Override
    public Status acceptStatusDetails(Status status) {
        return statusDao.save(status);
    }

    @Override
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException {
        return statusDao.findById(id)
                .orElseThrow(
                        () -> new StatusDetailsNotFoundException("Status not found for id: " + id)
                );
    }

    @Override
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException {
        Status status = statusDao.findByStatusName(statusName);
        if (status == null) {
            throw new StatusDetailsNotFoundException("Status not found for statusName: " + statusName);
        }
        return status;
    }

    @Override
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException {
        Status status = getStatusDetails(id);
        statusDao.delete(status);
        return true;
    }

    @Override
    public List<Status> getAllStatusDetails() {
        return statusDao.findAll();
    }
}
