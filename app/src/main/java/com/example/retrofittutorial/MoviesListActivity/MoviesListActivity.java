package com.example.retrofittutorial.MoviesListActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittutorial.API.MoviesAPIRequester;
import com.example.retrofittutorial.Models.BaseResponse;
import com.example.retrofittutorial.Models.MovieModel;
import com.example.retrofittutorial.Models.MoviesListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesListActivity extends AppCompatActivity {
    RecyclerView moviesList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        moviesList = (RecyclerView) findViewById(R.id.movies_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://yts.mx")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        MoviesAPIRequester apiRequester = retrofit.create(MoviesAPIRequester.class);
        Call<BaseResponse<MoviesListData>> call = apiRequester.getMoviesList(2);

        call.enqueue(new Callback<BaseResponse<MoviesListData>>() {
            @Override
            public void onResponse(Call<BaseResponse<MoviesListData>> call, Response<BaseResponse<MoviesListData>> response) {
                BaseResponse<MoviesListData> moviesBaseResponse = response.body();
                List<MovieModel> movies = moviesBaseResponse.getData().getMovies();

            }

            @Override
            public void onFailure(Call<BaseResponse<MoviesListData>> call, Throwable t) {
                Toast.makeText(MoviesListActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
