package com.example.testapp.ui.vidgets

import android.view.View
import android.widget.ImageView
import com.example.common.utils.loadPoster
import com.example.domain.entity.NowPlayingMovieModel
import com.example.testapp.R

class NowPlayingViewHolder(
    itemView: View,
    private val onclickListener: View.OnClickListener
): BasePagingViewHolder<NowPlayingMovieModel>(itemView){

    private val poster: ImageView = bindLazy(R.id.iv_poster)

    override fun bindItem(item: NowPlayingMovieModel?) {
        poster.setOnClickListener {view ->
            item?.let {model ->
                view.id = model.id
                onclickListener.onClick(view)
            }
        }
        poster.loadPoster(
            item?.posterPath,
            R.drawable.ic_no_image,
            50)//TODO hardcoded rounding and some image as placeholder
    }
}
