package com.msla_mac.lam_omdb_api_final

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


internal class MoviesAdapter(
    private var moviesList : List<MoviesItem>,
    private val listener: (position: Int) -> Unit
    ): RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var title : TextView = view.findViewById(R.id.movieTitleText)
        var year: TextView = view.findViewById(R.id.movieYearText)
        var imdbID: TextView = view.findViewById(R.id.imbdIDText)
        var type: TextView = view.findViewById(R.id.showTypeText)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View){
            listener(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //get the data from the list and fill in the various CELL from fields
        val movieItem = moviesList[position]

        holder.title.text = movieItem.Title
        holder.year.text = movieItem.Year.toString()
        holder.imdbID.text = movieItem.imdbID
        holder.type.text = movieItem.Type
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}
