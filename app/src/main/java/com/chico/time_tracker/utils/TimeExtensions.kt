package com.chico.time_tracker.utils

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun String.parseTimeToMillis(pattern: String = "yyyy-MM-dd HH:mm"):Long{
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.parse(this).time
}

fun String.parseDateToMillisDdMmYyyy(pattern: String = "dd.mm.yyyy"):Long{
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.parse(this).time
}

fun String.parseTimeToMillisHhMm(pattern: String = "hh.mm"):Long{
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.parse(this).time
}

fun Long.parseDateTimeFromMillisYyyyMmDdHhMm(pattern: String = "yyyy.MM.dd HH:mm"):String{
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(this)
}

fun Long.parseTimeFromMillisHhMm(pattern: String = "HH.mm"):String{
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(this)
}

fun Long.parseDateFromMillisDdMmYyyy(pattern: String = "dd.MM.yyyy"):String{
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(this)
}