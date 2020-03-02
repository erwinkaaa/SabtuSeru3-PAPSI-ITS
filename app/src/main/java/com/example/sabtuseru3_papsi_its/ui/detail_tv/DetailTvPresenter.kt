package com.example.sabtuseru3_papsi_its.ui.detail_tv

import com.example.sabtuseru3_papsi_its.helper.CoroutineContextProvider
import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailTvPresenter(
    private val view: DetailTvView,
    private val gson: Gson,
    private val apiRepository: ApiRepository,
    private val contextPool: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun loadTvById(id: String) {
        view.showLoading()

        GlobalScope.launch(contextPool.main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(TheMovieDBAPI.tvByIdUrl(id)).await(),
                DetailTvResponseModel::class.java
            )
            view.processTvData(data)
            view.hideLoading()
        }

    }

}