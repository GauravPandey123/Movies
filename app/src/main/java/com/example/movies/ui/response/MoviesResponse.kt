package com.example.movies.ui.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: ArrayList<ResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)