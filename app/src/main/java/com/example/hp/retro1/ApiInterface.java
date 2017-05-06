package com.example.hp.retro1;

import android.content.SharedPreferences;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 3/8/2017.
 */

public interface ApiInterface {

    @GET("movie/now_playing")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRated1Movies(@Query("api_key") String apiKey);
    @GET("movie/popular")
    Call<MovieResponse> getTopRated2Movies(@Query("api_key") String apiKey);
}
