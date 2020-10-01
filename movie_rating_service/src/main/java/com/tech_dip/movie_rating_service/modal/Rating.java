package com.tech_dip.movie_rating_service.modal;

public class Rating {

    private int  movieId;
    private int totalRating;
    private int userId;

    public long getMovieId() {
        return movieId;
    }


    public Rating () {

    }


    public Rating(int userId,int movieId, int totalRating) {
        this.userId = userId;
        this.movieId = movieId;
        this.totalRating = totalRating;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

}
