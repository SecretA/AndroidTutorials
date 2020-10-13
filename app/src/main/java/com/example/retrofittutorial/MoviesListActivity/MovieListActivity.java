package com.example.retrofittutorial.MoviesListActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.retrofittutorial.Models.MovieModel;
import com.example.retrofittutorial.MoviesListActivity.databinding.ActivityMoviesListBinding;

import java.util.ArrayList;


public class MovieListActivity extends AppCompatActivity implements MoviesContract.View, SwipeRefreshLayout.OnRefreshListener {
    private ActivityMoviesListBinding binding;
    private MoviesContract.Presenter presenter = new MoviesPresenterImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMoviesListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.moviesList.setLayoutManager(linearLayoutManager);
        binding.swiperefresh.setOnRefreshListener(this);
        binding.swiperefresh.setColorSchemeColors(Color.BLUE);
        presenter.onCreate(this);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        presenter.onViewStarted();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewStopped();
    }

    @Override
    public void updateMoviesList(ArrayList<MovieModel> movies) {
        binding.moviesList.setAdapter(new MovieListAdapter(movies));
    }

    @Override
    public void showLoader() {
        binding.loader.setVisibility(View.VISIBLE);
        binding.moviesList.setAlpha((float) 0.25);
    }

    @Override
    public void stopLoader() {
        binding.loader.setVisibility(View.GONE);
        binding.moviesList.setAlpha(1);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        binding.swiperefresh.setRefreshing(false);
        presenter.getMovies(0);
    }
}
