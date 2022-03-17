package com.arjun.MovieBookingSystem.dtos;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 *  This class will be used to convert client JSON request to Java object
 *  and Vice-versa
 */

public class MovieDTO {

    private int movieId;

    private String movieName;

    private String movieDescription;

    private LocalDateTime releaseDate;

    private int duration;

    private String CoverPhotoUrl;

    private String trailerUrl;

    private int statusId;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return CoverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        CoverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", CoverPhotoUrl='" + CoverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
