package com.msla_mac.lam_omdb_api_final

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class ShowMovie : BaseActivity() {
    lateinit var movie : MoviesItem

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_movie)

        val txtTitle: TextView = findViewById(R.id.txtTitle)
        val txtReleased: TextView = findViewById(R.id.txtReleased)

        val txtDirector: TextView = findViewById(R.id.txtDirector)
        val txtActor: TextView = findViewById(R.id.txtActors)
        val txtAwards: TextView = findViewById(R.id.txtAwards)
        val txtRated: TextView = findViewById(R.id.txtRated)
        val txtPoster: TextView = findViewById(R.id.txtPoster)
        val txtPlot: TextView = findViewById(R.id.txtPlot)
        val movieImage: ImageView = findViewById(R.id.movieImage)

        movie = moviesList[ currentRecord ]


        txtTitle.text = movie.Title
        txtReleased.text = movie.Released
        txtDirector.text = movie.Director
        txtActor.text = movie.Actor
        txtAwards.text = movie.Awards
        txtRated.text = movie.Rated
        txtPoster.text = movie.Poster
        txtPlot.text = movie.Plot


        val imageUrl = movie.Poster

        val imageRequest = ImageRequest(
            imageUrl,
            { bitmap -> // response listener
                movieImage.setImageBitmap(bitmap)
            },
            0, // max width
            0, // max height
            ImageView.ScaleType.CENTER_CROP, // image scale type
            Bitmap.Config.ARGB_8888, // decode config
            { error -> // error listener
            }
        )

        VolleySingleton.getInstance(applicationContext)
            .addToRequestQueue(imageRequest)
    }

    fun showAllMoviesOnClick(v : View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    } // End of showAll onClick
}