package com.example.sabtuseru3_papsi_its.ui.detail_movie

interface DetailMovieView {
    fun showLoading()
    fun hideLoading()
    fun processMovieData(data: DetailMovieResponseModel)
}