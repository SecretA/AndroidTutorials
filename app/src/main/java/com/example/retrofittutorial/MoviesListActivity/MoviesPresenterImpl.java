package com.example.retrofittutorial.MoviesListActivity;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class MoviesPresenterImpl implements MoviesContract.Presenter {
    private MoviesRepo repo = new MoviesRepo();
    private MoviesContract.View view;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onCreate(MoviesContract.View view) {
        this.view = view;
        getMovies(0);
    }

    @Override
    public void onViewStarted() { }

    @Override
    public void getMovies(int page) {
        view.showLoader();
        disposable.add(
                repo.getMovies(page).subscribe(
                        successResponse ->
                        {
                            view.stopLoader();
                            if (successResponse != null) {
                                view.updateMoviesList(successResponse.getData().getMovies());
                            } else {
                                view.updateMoviesList(new ArrayList<>());
                                view.showErrorMessage("Something Is Wrong :(");
                            }
                        },
                        errorResponse ->  {
                            view.stopLoader();
                            view.updateMoviesList(new ArrayList<>());
                            view.showErrorMessage("Something Is Wrong :(");
                        }
                )
        );
    }

    @Override
    public void onViewStopped() {
        disposable.dispose();
    }
}
