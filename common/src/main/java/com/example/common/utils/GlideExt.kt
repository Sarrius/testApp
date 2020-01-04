package com.example.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(imgPath: String?, placeholderId: Int?, roundingRadius: Int) {

    //TODO harcoded url
    //img size w154
    val imgUrl = "http://image.tmdb.org/t/p/w342$imgPath"

    Glide.with(this)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .apply(RequestOptions().transform(RoundedCorners(roundingRadius)))
        .apply {
            placeholderId?.let {
                placeholder(it)
                error(it)
            }
        }
        .into(this)
}
