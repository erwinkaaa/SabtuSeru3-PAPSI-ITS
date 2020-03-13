package com.example.sabtuseru3_papsi_its.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.ui.detail_tv.DetailTvActivity
import kotlinx.android.synthetic.main.fragment_tv_show.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private lateinit var adapter: TvShowAdapter
    private var tvShows = mutableListOf<TvShowModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = TvShowAdapter(tvShows) {
            startActivity<DetailTvActivity>(DetailTvActivity.TV_ID to it.id)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

}
