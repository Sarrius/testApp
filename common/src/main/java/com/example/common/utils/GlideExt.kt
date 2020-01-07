package com.example.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.R


fun ImageView.loadPoster(imgPath: String?, placeholderId: Int?, roundingRadius: Int) {

    //TODO harcoded base url
    //img size w154
    val imgUrl = "http://image.tmdb.org/t/p/w342$imgPath"

    Glide.with(this)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .apply(RequestOptions().apply{
            transform(RoundedCorners(roundingRadius))
//            override(
//                ScreenUtils.convertDpToPixel(context.resources.getDimension(R.dimen.poster_height), context).toInt(),
//                ScreenUtils.convertDpToPixel(context.resources.getDimension(R.dimen.poster_width), context).toInt())
        })
        .apply {
            placeholderId?.let {
                placeholder(it)
                error(it)
            }
        }
        .into(this)
}
