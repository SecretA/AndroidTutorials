package com.example.retrofittutorial.API;

import com.example.retrofittutorial.Models.BaseResponse;
import com.example.retrofittutorial.Models.MovieModel;
import com.example.retrofittutorial.Models.MoviesListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPIRequester {
    @GET("/api/v2/list_movies.json")
    Call<BaseResponse<MoviesListData>> getMoviesList(@Query("page") int page);
}
