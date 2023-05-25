package com.msla_mac.lam_omdb_api_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : BaseActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var moviesListAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movieRecycler)
        moviesListAdapter = MoviesAdapter(moviesList) { position ->
            toastIt("You selected position: $position")

            //perform whatever you want onclick
            val intent = Intent(this, ShowRecord::class.java)
            currentRecord = position
            startActivity(intent)

        }

        //toastIt("Created list")

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = moviesListAdapter

        moviesListAdapter.notifyDataSetChanged()

        ///Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)


        ///Request a string response from the provided URL.
        val stringRequest = JsonArrayRequest(
            Request.Method.GET,
            baseUrl,
            null, //jsonRequestObject
            { response ->

                for (i in 0 until response.length()) {
                    val record: JSONObject = response.getJSONObject(i)
                    val title = record.getString("Title")
                    val year = record.getInt("Year")
                    val imdbID = record.getString("imdbID")
                    val type = record.getString("Type")
                    val released = record.getString("Released")
                    val director = record.getString("Director")
                    val actor = record.getString("Actor")
                    val awards = record.getString("Awards")
                    val poster = record.getString("Poster")
                    val plot = record.getString("Plot")
                    val rated = record.getString("Rated")

                    val recordsItem = MoviesItem(title, year, imdbID, type, released, director, actor, awards, poster, plot, rated)
                    moviesList.add(recordsItem)
                }
                moviesListAdapter.notifyDataSetChanged()

                //display the first 500 characters of the response string.
                Log.i("CRUDapi", "Response is: ${response.toString()}")
            },
            {
                Log.i("CRUDapi", "It no worky - ${it.message}")
            })

        //Add the request to the RequestQueue.
        stringRequest.setShouldCache(false) //this forces information retrieval from the network again and not the volley cache data file in the project.
        queue.add(stringRequest)




    }
}