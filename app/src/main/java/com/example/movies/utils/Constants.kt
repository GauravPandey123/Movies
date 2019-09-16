package com.example.movies.utils

import java.lang.reflect.Type
import java.util.ArrayList

class Constants {
    // network]

    companion object {
        val MOVIES_ARRAY_DATA_TAG = "results"
        val POPULAR_MOVIES_BASE_URL = "https://api.themoviedb.org/3/movie/popular/"
        private val IMAGE_URL_PREFIX = "https://image.tmdb.org/t/p/"
        val SMALL_IMAGE_URL_PREFIX = IMAGE_URL_PREFIX + "w300"
        val BIG_IMAGE_URL_PREFIX = IMAGE_URL_PREFIX + "w500"
        val API_KEY_REQUEST_PARAM = "api_key"
        val LANGUAGE_REQUEST_PARAM = "language"
        val PAGE_REQUEST_PARAM = "page"
        val API_KEY = "04f2f288263683f12131ae2ae1d348c6"
        val LANGUAGE = "en"
        val LOADING_PAGE_SIZE = 20
        // DB
        val DATA_BASE_NAME = "TMBb.db"
        val NUMBERS_OF_THREADS = 3
    }
}