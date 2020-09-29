package com.example.retrofittutorial.Models;

import java.util.ArrayList;

public class MoviesListData {
    int movie_count;
    int limit;
    int page_number;
    ArrayList<MovieModel> movies;

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
