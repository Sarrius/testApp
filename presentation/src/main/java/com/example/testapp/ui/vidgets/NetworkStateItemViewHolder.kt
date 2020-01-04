package com.example.testapp.ui.vidgets

import android.view.View
import com.example.domain.entity.NowPlayingMovieModel

class NetworkStateItemViewHolder(
    view: View
) : BasePagingViewHolder<NowPlayingMovieModel>(view) {

    override fun bindItem(item: NowPlayingMovieModel?) {

        //TODO leaving this viewholder as it is
        //this is just demo app, ok?
        when (item) {

            else -> {
                //show error
            }
        }
    }
}