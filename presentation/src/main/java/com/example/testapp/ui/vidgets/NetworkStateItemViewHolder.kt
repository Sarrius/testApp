package com.example.testapp.ui.vidgets

import android.view.View
import com.example.domain.entity.NowPlayingPosterModel

class NetworkStateItemViewHolder(
    view: View
) : BasePagingViewHolder<NowPlayingPosterModel>(view, null) {

    override fun bindItem(item: NowPlayingPosterModel?) {

        //TODO leaving this viewholder as it is
        //this is just demo app, ok?
        when (item) {

            else -> {
                //show error
            }
        }
    }
}