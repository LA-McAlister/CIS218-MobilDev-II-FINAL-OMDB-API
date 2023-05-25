package com.msla_mac.lam_omdb_api_final

class MoviesItem (var Title: String, var Year: Int, var imdbID: String, var Type: String, var Released: String, var Director: String, var Actor: String, var Awards: String, var Poster: String, var Plot: String, var Rated: String) {

    fun toCSV(): String {
        return "$Title, $Year, $imdbID, $Type, $Released, $Director, $Actor, $Awards, $Poster, $Plot, $Rated"
    }

    override fun toString(): String {
        return "$Title : $Year $imdbID $Type, $Released, $Director, $Actor, $Awards, $Poster, $Plot, $Rated"
    }
}