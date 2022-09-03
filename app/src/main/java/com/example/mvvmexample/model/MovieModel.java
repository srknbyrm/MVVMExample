package com.example.mvvmexample.model;

public class MovieModel {
    private String title;
    public MovieModel(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
