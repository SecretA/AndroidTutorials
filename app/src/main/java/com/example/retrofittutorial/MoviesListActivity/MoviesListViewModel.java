package com.example.retrofittutorial.MoviesListActivity;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.retrofittutorial.API.MoviesAPIRequester;
import com.example.retrofittutorial.Models.BaseResponse;
import com.example.retrofittutorial.Models.MoviesListData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesListViewModel extends ViewModel {
    private MutableLiveData<BaseResponse<MoviesListData>> moviesData;
    public LiveData<BaseResponse<MoviesListData>> getMovies() {
        if (moviesData == null) {
            moviesData = new MutableLiveData<BaseResponse<MoviesListData>>();
            loadMovies();
        }
        return moviesData;
    }

    private void loadMovies() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://yts.mx")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        MoviesAPIRequester apiRequester = retrofit.create(MoviesAPIRequester.class);
        Call<BaseResponse<MoviesListData>> call = apiRequester.getMoviesList(2);

        call.enqueue(new Callback<BaseResponse<MoviesListData>>() {
            @Override
            public void onResponse(Call<BaseResponse<MoviesListData>> call, Response<BaseResponse<MoviesListData>> response) {
                moviesData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<MoviesListData>> call, Throwable t) {
                //Handle Failure
            }
        });
    }
}
