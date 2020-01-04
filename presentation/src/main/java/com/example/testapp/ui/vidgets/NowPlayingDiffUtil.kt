package com.example.testapp.ui.vidgets

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.NowPlayingMovieExtendedModel

class NowPlayingDiffUtil: DiffUtil.ItemCallback<NowPlayingMovieExtendedModel>(){
    override fun areItemsTheSame(oldItem: NowPlayingMovieExtendedModel,
                                 newItem: NowPlayingMovieExtendedModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NowPlayingMovieExtendedModel,
                                    newItem: NowPlayingMovieExtendedModel
    ): Boolean {
        val overview = oldItem.overview ==newItem.overview
        val popularity = oldItem.popularity ==newItem.popularity
        val posterPath = oldItem.posterPath ==newItem.posterPath
        val releaseDate = oldItem.releaseDate ==newItem.releaseDate
        val title = oldItem.title ==newItem.title
        val voteAverage = oldItem.voteAverage ==newItem.voteAverage
        val voteCount = oldItem.voteCount ==newItem.voteCount

        return overview &&
                popularity &&
                posterPath &&
                releaseDate &&
                title &&
                voteAverage &&
                voteCount
    }
}