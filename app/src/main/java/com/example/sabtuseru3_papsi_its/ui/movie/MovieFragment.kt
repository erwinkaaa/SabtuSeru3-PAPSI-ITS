package com.example.sabtuseru3_papsi_its.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.repository.ApiRepository
import com.example.sabtuseru3_papsi_its.ui.detail_movie.DetailMovieActivity
import com.example.sabtuseru3_papsi_its.util.invisible
import com.example.sabtuseru3_papsi_its.util.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), MovieView {

    private lateinit var presenter: MoviePresenter
    private lateinit var adapter: MovieAdapter
    private var movies = mutableListOf<MovieModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = MoviePresenter(this, Gson(), ApiRepository())

        adapter = MovieAdapter(movies) {
            startActivity<DetailMovieActivity>(DetailMovieActivity.MOVIE_ID to it.id)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        presenter.loadMovies()
    }

    override fun showLoading() {
        progress_circular.visible()
    }

    override fun hideLoading() {
        progress_circular.invisible()
    }

    override fun processMovieData(data: List<MovieModel>) {
        adapter.setData(data)
    }
}
