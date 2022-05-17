package com.chico.time_tracker.sp

import android.content.SharedPreferences
import com.chico.time_tracker.const.ConstantsDef

class GetSP(private val sp: SharedPreferences) {

    private val minusOneInt = ConstantsDef.MINUS_ONE_INT

    fun getInt(argsKey: String): Int {
        return sp.getInt(argsKey, minusOneInt)
    }
}