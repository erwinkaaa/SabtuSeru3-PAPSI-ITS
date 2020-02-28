package com.example.sabtuseru3_papsi_its.ui.movie

interface MovieView {
    fun showLoading()
    fun hideLoading()
    fun processMovieData(data: List<MovieModel>)
}