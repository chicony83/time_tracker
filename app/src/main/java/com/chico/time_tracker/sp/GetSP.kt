package com.chico.time_tracker.sp

import android.content.SharedPreferences
import com.chico.time_tracker.const.ConstantsDef

class GetSP(private val sp: SharedPreferences) {

    private val minusOneInt = ConstantsDef.MINUS_ONE_INT
    private val zero = ConstantsDef.ZERO
    private val none = ConstantsDef.NONE

    fun getInt(argsKey: String): Int {
        return sp.getInt(argsKey, zero)
    }

    fun getLong(argsKey: String): Long {
        return sp.getLong(argsKey, zero.toLong())
    }

    fun getString(argsKey: String): String? {
        return sp.getString(argsKey,none)
    }
}