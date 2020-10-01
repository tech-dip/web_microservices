package com.tech_dip.movie_data_service.modal;

public class Movies {
    private int id;
    private String movieName;
    private String description;

    public Movies(int id , String movieName, String description) {
        this.id = id;
        this.movieName = movieName;
        this.description = description;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
