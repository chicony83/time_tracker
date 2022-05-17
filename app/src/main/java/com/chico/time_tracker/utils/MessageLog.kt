package com.chico.time_tracker.utils

import android.util.Log
import com.chico.time_tracker.const.ConstantsDef

object MessageLog {

    private const val tag = ConstantsDef.TAG

    fun log(message: String) {
        Log.i(tag, message)
    }
}