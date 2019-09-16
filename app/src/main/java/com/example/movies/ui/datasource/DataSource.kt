package com.example.movies.ui.datasource

import com.example.movies.ui.networkservice.RetrofitService
import com.example.movies.ui.response.MoviesResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import com.example.movies.utils.Result

suspend fun <T : Any> Call<T>.getResult(): Result<T> = suspendCoroutine {
    this.enqueue(object : Callback<T> {

        override fun onFailure(call: Call<T>?, error: Throwable?) =
            it.resume(Result.Error(error))

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (response?.body() != null)
            {
                it.resume(Result.Success(response.body()!!))
            }else
            {
                it.resume(Result.Error(Throwable("INTERNAL SERVER ERROR")))
            }
        }
    })
}

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)

    return this
}

inline fun <T : Any> Result<T>.onError(action: (Throwable) -> Unit) {
    if (this is Result.Error && error != null) action(error)
}


suspend fun onReportFeedRequest(apiKey : String,baseUrl:String):Result<MoviesResponse> = GlobalScope.async {
    return@async RetrofitService().getUnAuthorisedServiceApi(baseUrl).getMovies(apiKey).getResult()
}.await()



