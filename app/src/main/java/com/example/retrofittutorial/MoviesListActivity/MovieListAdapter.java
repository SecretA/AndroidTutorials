package com.example.retrofittutorial.MoviesListActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittutorial.Models.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    ArrayList<MovieModel> list;

    public MovieListAdapter(Context context, ArrayList<MovieModel> movies) {
        this.context = context;
        this.list = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_movie, parent, false));
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
    ImageView imageView;
    TextView textView;

    public MovieViewHolder(final View itemView){
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.movie_image);
        textView = (TextView) itemView.findViewById(R.id.movie_title);
    }

    public void setUpView(MovieModel movie){
        textView.setText(movie.getTitle());
        Picasso.get().load(movie.getMediumCoverImageURL()).into(imageView);
    }
}
