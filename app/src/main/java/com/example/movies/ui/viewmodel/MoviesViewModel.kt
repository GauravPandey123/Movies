package com.example.movies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.ui.networkservice.ApiResponse
import com.example.movies.ui.respositoy.MoviesRepository

class MoviesViewModel : ViewModel() {

    private val moviesRespository : MoviesRepository = MoviesRepository()

    fun getMoviesData(apikey : String) : MutableLiveData<ApiResponse> {
        return moviesRespository.moviesOptions(apikey)
    }
}