package com.example.movies.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.ui.response.MoviesResponse
import com.example.movies.ui.response.ResultsItem
import com.example.movies.utils.Constants.Companion.SMALL_IMAGE_URL_PREFIX
import com.squareup.picasso.Picasso

class MovieAdapter(val context: Context?, val arrayList: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text= arrayList.get(position)?.title
     //   holder.userrating.text= arrayList[position].results?.get(position)?.voteAverage.toString()
        val post = SMALL_IMAGE_URL_PREFIX+arrayList[position].posterPath
        Picasso.get().load(post).into(holder.imageViewMoview)


    }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewMoview = itemView.findViewById<ImageView>(R.id.thumbnail)
        val title = itemView.findViewById<TextView>(R.id.title)
        val userrating = itemView.findViewById<TextView>(R.id.userrating)
    }


}