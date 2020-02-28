package com.example.sabtuseru3_papsi_its.ui.detail_tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.example.sabtuseru3_papsi_its.util.invisible
import com.example.sabtuseru3_papsi_its.util.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_tv.*

class DetailTvActivity : AppCompatActivity(), DetailTvView {

    private lateinit var presenter: DetailTvPresenter

    companion object {
        const val TV_ID = "TV_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        val id = intent.getStringExtra(TV_ID) ?: ""
        presenter = DetailTvPresenter(this, Gson(), ApiRepository())
        presenter.loadTvById(id)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {
        progress_circular.visible()
        layout_detail_tv.invisible()
    }

    override fun hideLoading() {
        progress_circular.invisible()
        layout_detail_tv.visible()
    }

    override fun processTvData(data: DetailTvResponseModel) {
        Picasso.get().load(TheMovieDBAPI.IMAGE_URL + data.backdrop_path).into(iv_tv_backdrop)
        title = data.name
        tv_tv_title.text = data.name
        tv_tv_status.text = data.status
        tv_tv_number_of_seasons.text = data.number_of_seasons
        tv_tv_number_of_episodes.text = data.number_of_episodes
        tv_tv_overview.text = data.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
