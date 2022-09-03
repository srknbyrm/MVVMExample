package com.example.mvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvvmexample.adapter.MovieListAdapter;
import com.example.mvvmexample.model.MovieModel;
import com.example.mvvmexample.viewmodel.MovieListViewModel;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView noResultTextView = findViewById(R.id.noResultTextView);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MovieListAdapter(this, movieModelList);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMovieListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    movieModelList = movieModels;
                    adapter.setMovieList(movieModelList);
                    noResultTextView.setVisibility(View.GONE);
                }else {
                    System.out.println("Movie List empty");
                    noResultTextView.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.getMovies();

    }
}