package com.example.movies.ui.activtiy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.R
import com.example.movies.ui.fragment.MovieListFragment

class MoviesActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return
            }

            // Create a new Fragment to be placed in the activity layout
            val moviesListFragment = MovieListFragment()

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            moviesListFragment.setArguments(intent.extras)

            // Add the fragment to the 'fragmentsContainer' FrameLayout
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentsContainer, moviesListFragment).commit()
        }

}


