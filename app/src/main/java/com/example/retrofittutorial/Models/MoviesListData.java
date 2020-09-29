package com.example.retrofittutorial.Models;

import java.util.ArrayList;

public class MoviesListData {
    private int movie_count;
    private int limit;
    private int page_number;
    private ArrayList<MovieModel> movies;

    public int getMovieCount() {
        return movie_count;
    }

    public int getLimit() {
        return limit;
    }

    public int getPageNumber() {
        return page_number;
    }

    public ArrayList<MovieModel> getMovies() {
        return movies;
    }
}
