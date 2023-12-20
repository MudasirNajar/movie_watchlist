package com.example.movie_watchlist.models;

public class Movie {

    private String name;
    private double imdbRating;

    private int durationInMinutes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Movie() {

    }

    public Movie(String name, double imdbRating, int durationInMinutes) {
        this.name = name;
        this.imdbRating = imdbRating;
        this.durationInMinutes = durationInMinutes;
    }
}
