package com.example.testapp.ui.vidgets

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

class NowPlayingViewHolder(itemView: View, private val onclickListener: View.OnClickListener): RecyclerView.ViewHolder(itemView){

    @Suppress("UNCHECKED_CAST")
    fun <T : View> bindLazy(@IdRes res: Int): T {
        val view by lazy { itemView.findViewById<T>(res) }
        return view
    }

    fun bind(any: Any?){
        itemView.setOnClickListener {
            //TODO set view id
            onclickListener.onClick(it)
        }
    }
}
