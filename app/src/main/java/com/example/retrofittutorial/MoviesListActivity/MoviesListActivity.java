package com.example.retrofittutorial.MoviesListActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.retrofittutorial.Models.MovieModel;
import com.example.retrofittutorial.MoviesListActivity.databinding.ActivityMoviesListBinding;

import java.util.ArrayList;


public class MoviesListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final ActivityMoviesListBinding binding = ActivityMoviesListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.moviesList.setLayoutManager(linearLayoutManager);

        MoviesListViewModel model = new ViewModelProvider(this).get(MoviesListViewModel.class);
        model.getMovies().observe(this, moviesData -> {
            ArrayList<MovieModel> movies = moviesData.getData().getMovies();
            if (movies != null) {
                MovieListAdapter adapter = new MovieListAdapter(movies);
                binding.moviesList.setAdapter(adapter);
            }
        });
    }
}
