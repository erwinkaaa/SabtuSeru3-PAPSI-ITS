package com.example.sabtuseru3_papsi_its.ui.tvshow

import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TvShowPresenter(
    private val view: TvShowView,
    private val gson: Gson,
    private val apiRepository: ApiRepository
) {

    fun loadTvShows() {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(TheMovieDBAPI.discoverTvShowUrl()).await(),
                TVShowResponseModel::class.java
            )
            view.processTvShowData(data.results)
            view.hideLoading()
        }

    }

}