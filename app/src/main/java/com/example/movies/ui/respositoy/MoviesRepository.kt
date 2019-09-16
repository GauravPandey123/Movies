package com.example.movies.ui.respositoy

import androidx.lifecycle.MutableLiveData
import com.example.movies.ui.datasource.onError
import com.example.movies.ui.datasource.onReportFeedRequest
import com.example.movies.ui.datasource.onSuccess
import com.example.movies.ui.networkservice.ApiResponse
import com.example.movies.ui.networkservice.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesRepository {

    fun moviesOptions(apikey: String): MutableLiveData<ApiResponse> {
        val result = MutableLiveData<ApiResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = onReportFeedRequest(apikey,RetrofitService.BASE_URL)

            request.onSuccess {
                result.postValue(ApiResponse(it, null))
            }
            request.onError {
                result.postValue(ApiResponse(null, it))
            }
        }
        return result
    }
}