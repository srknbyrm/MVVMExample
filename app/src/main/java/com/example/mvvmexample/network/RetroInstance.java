package com.example.mvvmexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String BASE_URL = "https://63025394c6dda4f287b7d312.mockapi.io/movie/";
    private static Retrofit retrofit;
    public static Retrofit getRetroClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
