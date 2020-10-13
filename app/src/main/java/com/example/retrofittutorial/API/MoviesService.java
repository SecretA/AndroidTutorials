package com.example.retrofittutorial.API;

import com.example.retrofittutorial.Models.BaseResponse;
import com.example.retrofittutorial.Models.MoviesListData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {
    @GET("/api/v2/list_movies.json")
    Observable<BaseResponse<MoviesListData>> getMoviesList(@Query("page") int page);
}
