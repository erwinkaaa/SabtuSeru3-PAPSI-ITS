package com.example.sabtuseru3_papsi_its.ui.detail_movie

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
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity(), DetailMovieView {

    private lateinit var presenter: DetailMoviePresenter

    companion object {
        const val MOVIE_ID = "MOVIE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val id = intent.getStringExtra(MOVIE_ID) ?: ""
        presenter = DetailMoviePresenter(this, Gson(), ApiRepository())
        presenter.loadMovieById(id)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {
        progress_circular.visible()
        layout_detail_movie.invisible()
    }

    override fun hideLoading() {
        progress_circular.invisible()
        layout_detail_movie.visible()
    }

    override fun processMovieData(data: DetailMovieResponseModel) {
        Picasso.get().load(TheMovieDBAPI.IMAGE_URL + data.backdrop_path).into(iv_movie_backdrop)
        title = data.title
        tv_movie_title.text = data.title
        tv_movie_tagline.text = data.tagline
        tv_movie_release_date.text = data.release_date
        tv_movie_runtime.text = "${data.runtime} minutes"
        tv_movie_overview.text = data.overview
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
