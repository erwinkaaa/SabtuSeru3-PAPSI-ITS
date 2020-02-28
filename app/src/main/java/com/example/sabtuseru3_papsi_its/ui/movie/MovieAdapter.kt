package com.example.sabtuseru3_papsi_its.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.repository.TheMovieDBAPI
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_movie.view.*

class MovieAdapter(
    private val data: MutableList<MovieModel>,
    private val onClickListener: (MovieModel) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    fun setData(movie: List<MovieModel>) {
        data.clear()
        data.addAll(movie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_movie,
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
            data: MovieModel,
            onClickListener: (MovieModel) -> Unit
        ) {
            Picasso.get().load(TheMovieDBAPI.IMAGE_URL + data.poster_path).into(itemView.iv_movie_poster)
            itemView.tv_movie_title.text = data.title
            itemView.tv_movie_overview.text = data.overview
            containerView.setOnClickListener { onClickListener(data) }
        }
    }

}