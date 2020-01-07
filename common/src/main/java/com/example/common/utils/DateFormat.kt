package com.example.common.utils

import java.text.SimpleDateFormat

fun String.reformatDate(): String? {

    val outputFormat = SimpleDateFormat("MMMM dd, yyyy")
    val inputFormat = SimpleDateFormat("yyyy-mm-dd")

    val dateFromString = inputFormat.parse(this)
    return outputFormat.format(dateFromString)
}
