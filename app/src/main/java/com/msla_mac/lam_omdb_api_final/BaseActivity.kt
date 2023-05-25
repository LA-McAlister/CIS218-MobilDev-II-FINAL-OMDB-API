package com.msla_mac.lam_omdb_api_final

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var moviesList = ArrayList<MoviesItem>()
var currentRecord = 0
const val baseUrl = "https://www.omdbapi.com/?i=tt3896198&apikey=8917dc20"

open class BaseActivity() : AppCompatActivity() {

    open fun toastIt(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg, Toast.LENGTH_SHORT
        ).show()
    }
}