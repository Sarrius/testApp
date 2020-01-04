package com.example.testapp.ui.vidgets

import android.view.View
import android.widget.ImageView
import com.example.common.utils.loadImage
import com.example.domain.entity.NowPlayingPosterModel
import com.example.testapp.R

class NowPlayingViewHolder(
    itemView: View,
    onclickListener: View.OnClickListener
): BasePagingViewHolder<NowPlayingPosterModel>(itemView, onclickListener){

    private val poster: ImageView = bindLazy(R.id.iv_poster)

    override fun bindItem(item: NowPlayingPosterModel?) {
        super.bindItem(item)
        poster.loadImage(item?.posterPath,
            android.R.drawable.progress_indeterminate_horizontal,
            50)//TODO hardcoded rounding
    }
}
