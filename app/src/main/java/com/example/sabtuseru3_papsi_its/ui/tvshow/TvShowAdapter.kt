package com.example.sabtuseru3_papsi_its.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sabtuseru3_papsi_its.R
import kotlinx.android.extensions.LayoutContainer

class TvShowAdapter(
//    private val data: MutableList<TvModel>,
//    private val onClickListener: (TvModel) -> Unit
) :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

//    fun setData(tv: List<TvModel>) {
//        data.clear()
//        data.addAll(tv)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_tv,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindItem(data[position], onClickListener)
    }

    override fun getItemCount(): Int = 0 //data.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

//        fun bindItem(
//            data: TvModel,
//            onClickListener: (TvModel) -> Unit
//        ) {
//            containerView.setOnClickListener { onClickListener(data) }
//        }
    }

}