package com.example.movies.ui.networkservice

import com.example.movies.ui.response.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

 @GET("movie/popular")
 fun getMovies(@Query("api_key") apitype : String)  : Call<MoviesResponse>

}