package com.example.sabtuseru3_papsi_its.ui.movie

import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviePresenter(
    private val view: MovieView,
    private val gson: Gson,
    private val apiRepository: ApiRepository
) {

    fun loadMovies() {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(TheMovieDBAPI.discoverMovieUrl()).await(),
                MovieResponseModel::class.java
            )
            view.processMovieData(data.results)
            view.hideLoading()
        }

    }

}