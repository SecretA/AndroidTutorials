package com.example.retrofittutorial.MoviesListActivity;

import com.example.retrofittutorial.API.MoviesService;
import com.example.retrofittutorial.Models.BaseResponse;
import com.example.retrofittutorial.Models.MoviesListData;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepo {
    private MoviesService service;
    private final String HOST_URL = "https://yts.mx";
    public MoviesRepo() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit = builder.build();
        service = retrofit.create(MoviesService.class);
    }

    public Observable<BaseResponse<MoviesListData>> getMovies(int page){
        return service.getMoviesList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
