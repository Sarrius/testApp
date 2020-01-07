package com.example.common.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager

object ScreenUtils {

    private fun getDisplayMetrics(context: Context): DisplayMetrics {
        val metrics = DisplayMetrics()
        val w = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        w.defaultDisplay.getMetrics(metrics)
        return metrics
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (getDisplayMetrics(context).densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (getDisplayMetrics(context).densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}