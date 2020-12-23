package com.example.movie_tv

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private var mMovieRepository:MovieRepository = MovieRepository(application)
    private var mAllMovies:LiveData<List<Movie>> = mMovieRepository.getAllMovies()

    fun insert(movie:Movie){
        mMovieRepository.insert(movie)
    }

    fun update(movie: Movie){
        mMovieRepository.update(movie)
    }

    fun delete(movie:Movie){
        mMovieRepository.delete(movie)
    }

    fun deleteAll(){
        mMovieRepository.deleteAll()
    }

    fun getAllMovies():LiveData<List<Movie>> {
        return mAllMovies
    }
}