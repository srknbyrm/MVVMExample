package com.example.mvvmexample.network;

import com.example.mvvmexample.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("movies")
    Call<List<MovieModel>> getMovieList();
}
