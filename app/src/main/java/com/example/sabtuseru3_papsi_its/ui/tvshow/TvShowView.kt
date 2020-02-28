package com.example.sabtuseru3_papsi_its.ui.tvshow

interface TvShowView {
    fun showLoading()
    fun hideLoading()
    fun processTvShowData(data: List<TvShowModel>)
}