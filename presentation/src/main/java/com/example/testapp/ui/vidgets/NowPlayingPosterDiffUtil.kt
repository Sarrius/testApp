package com.example.testapp.ui.vidgets

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.NowPlayingPosterModel

class NowPlayingPosterDiffUtil: DiffUtil.ItemCallback<NowPlayingPosterModel>(){
    override fun areItemsTheSame(oldItem: NowPlayingPosterModel,
                                 newItem: NowPlayingPosterModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NowPlayingPosterModel,
                                    newItem: NowPlayingPosterModel
    ): Boolean {
        return oldItem.posterPath == newItem.posterPath
    }
}