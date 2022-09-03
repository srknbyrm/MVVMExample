package com.example.mvvmexample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.model.MovieModel;
import com.example.mvvmexample.network.APIService;
import com.example.mvvmexample.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<List<MovieModel>> movieList;
    public MovieListViewModel(){
        movieList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovieListObserver(){
        return movieList;
    }
    public void getMovies(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                System.out.println("Success Request");
                System.out.println(response.body().get(0).getTitle());
                movieList.postValue(response.body());
            }
            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                System.out.println("Failed Request");
                movieList.postValue(null);
            }
        });
    }
}
