package com.msla_mac.lam_omdb_api_final

class MoviesItem (var Title: String, var Year: Int, var imdbID: String, var Type: String) {

    fun toCSV(): String {
        return "$Title, $Year, $imdbID, $Type"
    }

    override fun toString(): String {
        return "$Title : $Year $imdbID $Type"
    }
}