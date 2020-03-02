package com.example.sabtuseru3_papsi_its.ui.detail_movie

import com.example.sabtuseru3_papsi_its.helper.CoroutineContextProvider
import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailMoviePresenter(
    private val view: DetailMovieView,
    private val gson: Gson,
    private val apiRepository: ApiRepository,
    private val contextPool: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun loadMovieById(id: String) {
        view.showLoading()

        GlobalScope.launch(contextPool.main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(TheMovieDBAPI.movieByIdUrl(id)).await(),
                DetailMovieResponseModel::class.java
            )
            view.processMovieData(data)
            view.hideLoading()
        }

    }

}