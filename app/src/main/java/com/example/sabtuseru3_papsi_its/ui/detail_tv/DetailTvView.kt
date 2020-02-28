package com.example.sabtuseru3_papsi_its.ui.detail_tv

interface DetailTvView {
    fun showLoading()
    fun hideLoading()
    fun processTvData(data: DetailTvResponseModel)
}