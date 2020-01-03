package com.example.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun ImageView.loadImage(imgPath: String?, placeholderId: Int?) {

    //TODO harcoded url
    val imgUrl = "http://image.tmdb.org/t/p/w342$imgPath"

    Glide.with(this)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .apply {
            placeholderId?.let {
                placeholder(it)
                error(it)
            }
        }
        .into(this)
}
