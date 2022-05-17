package com.chico.time_tracker.ui.newEntry

import android.app.Application
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.AndroidViewModel
import com.chico.time_tracker.const.ConstantsSp
import com.chico.time_tracker.db.entity.WorkingTime
import com.chico.time_tracker.sp.GetSP
import com.chico.time_tracker.sp.SetSP
import com.chico.time_tracker.utils.MessageLog

class NewEntryViewModel(
    private val app: Application
) : AndroidViewModel(app) {

    private val spName: String = ConstantsSp.SP_NAME

    private val sp = app.getSharedPreferences(spName,MODE_PRIVATE)
    private val spEditor = sp.edit()
    private val getSp = GetSP(sp)
    private val setSP = SetSP(spEditor)

    fun chekWorkingTime(workingTime: WorkingTime): Boolean {
        return true
    }

    fun saveWorkingTime(workingTime: WorkingTime) {
        workingTime.toString()
        MessageLog.log("saved...")
    }


}