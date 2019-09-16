package com.example.movies.ui.networkservice



import com.example.movies.ui.response.MoviesResponse
import com.example.movies.utils.Result
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        // const val BASE_URL="http://ng-app.us-west-2.elasticbeanstalk.com/"
        //  const val BASE_URL="http://ngapp-pre-1.us-west-2.elasticbeanstalk.com/"
        const val TEST_BASE = "https://test.neargroup.me"
        //const val BASE_URL="https://testfeeds.ngrok.io"
        //const val BASE_URL="https://braintreesub.ngrok.io"
    }


    private fun getUnAuthorisedClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    private fun getAuthorisedClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HeaderIntercepter())
            .readTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).build()
    }


    private fun getUnauthorisedRetrofit(baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getUnAuthorisedClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getAuthorisedRetrofit(baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getAuthorisedClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getAuthorisedServiceApi(baseUrl: String) =
        getAuthorisedRetrofit(baseUrl).create(ApiService::class.java)

    fun getUnAuthorisedServiceApi(baseUrl: String) =
        getUnauthorisedRetrofit(baseUrl).create(ApiService::class.java)


    class HeaderIntercepter : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Type", "android")
                    .build()
            )
        }

    }
}
