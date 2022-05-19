package com.chico.time_tracker.sp

import android.content.SharedPreferences
import com.chico.time_tracker.utils.MessageLog

class SetSP(
    private val spEditor: SharedPreferences.Editor
) {

    fun putToSp(
        args: String,string: String
    ){
        spEditor.putString(args,string)
        spCommit()
    }

    fun putToSp(
        args:String,
        int: Int
    ){
        logSetSp(args,int)
        spEditor.putInt(args,int)
        spCommit()
    }

    private fun spCommit() {
        spEditor.commit()
    }

    private fun logSetSp(args: String, int: Int) {
        val message = " save to sp args $args, value $int"
        MessageLog.log(message)
    }

    fun putToSp(args: String, long: Long) {
        spEditor.putLong(args,long)
        spCommit()
    }

}