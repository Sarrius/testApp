package com.example.testapp.ui.vidgets

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.NowPlayingMovieModel

class NowPlayingPosterDiffUtil: DiffUtil.ItemCallback<NowPlayingMovieModel>(){
    override fun areItemsTheSame(oldItem: NowPlayingMovieModel,
                                 newItem: NowPlayingMovieModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NowPlayingMovieModel,
                                    newItem: NowPlayingMovieModel
    ): Boolean {
        return oldItem.posterPath == newItem.posterPath
    }
}