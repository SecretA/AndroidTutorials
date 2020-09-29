package com.example.retrofittutorial.Models;

import java.util.List;

public class MoviesListData {
    int movie_count;
    int limit;
    int page_number;
    List<MovieModel> movies;

    public int getMovieCount() {
        return movie_count;
    }

    public int getLimit() {
        return limit;
    }

    public int getPageNumber() {
        return page_number;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }
}
