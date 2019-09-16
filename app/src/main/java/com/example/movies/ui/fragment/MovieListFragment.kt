package com.example.movies.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.ui.adapter.MovieAdapter
import com.example.movies.ui.networkservice.ApiResponse
import com.example.movies.ui.response.MoviesResponse
import com.example.movies.ui.response.ResultsItem
import com.example.movies.ui.viewmodel.MoviesViewModel
import com.example.movies.utils.Constants.Companion.API_KEY
import kotlinx.android.synthetic.main.fragment_movies.*

class MovieListFragment : Fragment() {

    private lateinit var movieView : View

    private lateinit var moviesListAdapter : MovieAdapter

    private lateinit var movieViewModel : MoviesViewModel

    private lateinit var moviewArrayList : ArrayList<ResultsItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        movieView = inflater.inflate(R.layout.fragment_movies,container,false)
        setUpElement()
        return movieView
    }


    fun setUpElement(){
        moviewArrayList = ArrayList()
        movieViewModel= ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        movieViewModel.getMoviesData(API_KEY).observe(this, Observer {
           handleResponse(it)
        })
    }

    private fun handleResponse(it: ApiResponse?) {
     if(it?.response!=null){
      val moviewData = it.response as MoviesResponse
      handleResponse(moviewData.results)

     }

    }

    private fun handleResponse(results: ArrayList<ResultsItem>) {
        moviewArrayList.addAll(results)
        moviesRecyclerView.layoutManager= LinearLayoutManager(activity)
        moviesListAdapter= MovieAdapter(context,moviewArrayList)
        moviesRecyclerView.adapter = moviesListAdapter
    }

    private fun handleResponse(it: MoviesResponse) {


    }
}


