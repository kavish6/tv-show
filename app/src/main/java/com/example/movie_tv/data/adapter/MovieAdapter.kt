package com.example.movie_tv.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_tv.R
import com.example.movie_tv.data.model.Movie

class MovieAdapter(context: Context, listener : (item : Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val mInflater : LayoutInflater = LayoutInflater.from(context)
    private var mMovies : List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var itemView:View = mInflater.inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var currentMovie: Movie = mMovies[position]
        var tmpRating:Int = currentMovie.movieRating

        holder.titleView.text = currentMovie.movieName
        holder.ratingView.text = "Rating : $tmpRating / 10"

        holder.planButton.text = if(currentMovie.wishList){
            "Drop"
        }else{
            "Wish"
        }

        holder.watchingButton.isEnabled = if(currentMovie.watching){
            holder.watchedButton.isEnabled = true
            false
        }else{
            true
        }

        holder.watchedButton.isEnabled = if(currentMovie.watched){
            holder.watchingButton.isEnabled = true
            false
        }else{
            true
        }
    }

    fun setMovies(movies : List<Movie>){
        mMovies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView:TextView = itemView.findViewById(R.id.title_view)
        var ratingView:TextView = itemView.findViewById(R.id.rating_view)
        var planButton: Button = itemView.findViewById(R.id.plan_button)
        var watchingButton: Button = itemView.findViewById(R.id.watching_button)
        var watchedButton: Button = itemView.findViewById(R.id.watched_button)
    }
}