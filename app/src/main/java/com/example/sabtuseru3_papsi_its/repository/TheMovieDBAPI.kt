package com.example.sabtuseru3_papsi_its.repository

object TheMovieDBAPI {

    private const val BASE_URL: String = "https://api.themoviedb.org/3"
    const val IMAGE_URL: String = "https://image.tmdb.org/t/p/original"
    private const val API_KEY: String = "77ec6758858d2c68ba390df47a311dcb"

    fun discoverMovieUrl(): String {
        return "$BASE_URL/discover/movie?api_key=$API_KEY"
    }

    fun discoverTvShowUrl(): String {
        return "$BASE_URL/discover/tv?api_key=$API_KEY"
    }

    fun movieByIdUrl(id: String): String {
        return "$BASE_URL/movie/$id?api_key=$API_KEY"
    }

    fun tvByIdUrl(id: String): String {
        return "$BASE_URL/tv/$id?api_key=$API_KEY"
    }

}