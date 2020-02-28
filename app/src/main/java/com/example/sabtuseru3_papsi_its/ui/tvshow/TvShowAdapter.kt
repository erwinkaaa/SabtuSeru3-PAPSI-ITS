package com.example.sabtuseru3_papsi_its.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_tv.view.*

class TvShowAdapter(
    private val data: MutableList<TvShowModel>,
    private val onClickListener: (TvShowModel) -> Unit
) :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    fun setData(tv: List<TvShowModel>) {
        data.clear()
        data.addAll(tv)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_tv,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position], onClickListener)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(
            data: TvShowModel,
            onClickListener: (TvShowModel) -> Unit
        ) {
            Picasso.get().load(TheMovieDBAPI.IMAGE_URL + data.poster_path).into(itemView.iv_tv_poster)
            itemView.tv_tv_title.text = data.name
            itemView.tv_tv_overview.text = data.overview
            containerView.setOnClickListener { onClickListener(data) }
        }
    }

}