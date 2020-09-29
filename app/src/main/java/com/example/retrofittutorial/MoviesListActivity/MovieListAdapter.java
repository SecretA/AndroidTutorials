package com.example.retrofittutorial.MoviesListActivity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittutorial.Models.MovieModel;
import com.example.retrofittutorial.MoviesListActivity.databinding.CellMovieBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<MovieModel> list;

    public MovieListAdapter(ArrayList<MovieModel> movies) {
        this.list = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CellMovieBinding binding = CellMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolder) holder).setUpView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MovieViewHolder extends RecyclerView.ViewHolder {
    CellMovieBinding binding;
    public MovieViewHolder(CellMovieBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setUpView(MovieModel movie){
        binding.movieTitle.setText(movie.getTitle());
        Picasso.get().load(movie.getMediumCoverImageURL()).into(binding.movieImage);
    }
}
