package com.example.retrofittutorial.Models;

public class MovieModel {
    private int id;
    private String title;
    private String medium_cover_image;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMediumCoverImageURL() { return medium_cover_image; }
}
