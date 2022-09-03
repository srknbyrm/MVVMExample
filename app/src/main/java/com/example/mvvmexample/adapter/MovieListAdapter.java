package com.example.mvvmexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.R;
import com.example.mvvmexample.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList){
        this.context = context;
        this.movieList = movieList;
    }
    public void setMovieList(List<MovieModel> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        System.out.println("Holder" + this.movieList.get(position).getTitle());
        holder.titleTextView.setText(this.movieList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (this.movieList != null){
            return this.movieList.size();
        }
        return 0;
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        public MyViewHolder(View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
