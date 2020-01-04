package com.example.testapp.ui.vidgets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel
import com.example.testapp.R

class NowPlayingPagedListAdapter(
    diffUtilCallback: DiffUtil.ItemCallback<NowPlayingMovieModel>,
    private val onClickListener: View.OnClickListener
) : PagedListAdapter<NowPlayingMovieModel, BasePagingViewHolder<NowPlayingMovieModel>>(diffUtilCallback) {

    private var networkState: NetworkState? = null

    companion object {
        private const val TYPE_PROGRESS = 0
        private const val TYPE_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): BasePagingViewHolder<NowPlayingMovieModel> {
        if (viewType == TYPE_PROGRESS) {
            return NetworkStateItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_progress,
                        parent,
                        false
                    )
            )
        }
        return NowPlayingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_now_playing,
                    parent,
                    false
                ),
            onclickListener = onClickListener
        )
    }

    override fun onBindViewHolder(holder: BasePagingViewHolder<NowPlayingMovieModel>, position: Int) {
        holder.bindItem(getItem(position))
    }

    override fun getItemViewType(position: Int): Int =
        if (hasExtraRow() && position == itemCount - 1) TYPE_PROGRESS
        else TYPE_ITEM

    fun setNetworkState(networkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = networkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != this.networkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    private fun hasExtraRow(): Boolean {
        return networkState != null && networkState !== NetworkState.SUCCESS
    }


}