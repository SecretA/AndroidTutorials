package com.example.retrofittutorial.BasePresenter;

public interface BasePresenter<T> {

    void onCreate(T view);

    void onViewStarted();

    void onViewStopped();
}