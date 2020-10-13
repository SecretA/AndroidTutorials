package com.example.retrofittutorial.MoviesListActivity;

import com.example.retrofittutorial.BasePresenter.BasePresenter;
import com.example.retrofittutorial.Models.MovieModel;

import java.util.ArrayList;

interface MoviesContract {
    interface View {
        void updateMoviesList(ArrayList<MovieModel> movies);

        void showLoader();

        void stopLoader();

        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter<View> {
        void getMovies(int page);
    }

}
