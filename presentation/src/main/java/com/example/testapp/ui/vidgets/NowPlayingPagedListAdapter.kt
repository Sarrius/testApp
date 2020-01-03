package com.example.testapp.ui.vidgets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.NowPlayingPosterExtendedModel
import com.example.testapp.R

class NowPlayingPagedListAdapter(
    diffUtilCallback: DiffUtil.ItemCallback<NowPlayingPosterExtendedModel>,
    private val onClickListener: View.OnClickListener
) : PagedListAdapter<NowPlayingPosterExtendedModel, NowPlayingViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        return NowPlayingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_now_playing,
                    parent,
                    false),
            onclickListener = onClickListener
        )
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}