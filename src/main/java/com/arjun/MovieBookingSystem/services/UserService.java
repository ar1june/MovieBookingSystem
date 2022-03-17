package com.arjun.MovieBookingSystem.services;

import com.arjun.MovieBookingSystem.entities.User;
import com.arjun.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.arjun.MovieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.arjun.MovieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    /**
     *  Allow the creation of users
     *  I should not be allowed to use existing/duplicate user
     *  or of wrong type
     */
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    /**
     *  Fetch the user details based on Id
     */
    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    /**
     * Fetch User by name
     */
    public User getUserDetailsByName(String username) throws UserDetailsNotFoundException;

    /**
     * Update the user details
     */
    public User updateUserDetails(int id, User user) throws UserDetailsNotFoundException;

}
