package com.example.testapp.ui.vidgets

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

open class BasePagingViewHolder<Item>(itemView: View,
                           private val onclickListener: View.OnClickListener?
) : RecyclerView.ViewHolder(itemView){

    private var item: Item? = null

    @Suppress("UNCHECKED_CAST")
    fun <T : View> bindLazy(@IdRes res: Int): T {
        val view by lazy { itemView.findViewById<T>(res) }
        return view
    }

    open fun bindItem(item: Item?) {
        this.item = item
        itemView.setOnClickListener(onclickListener)
    }
}