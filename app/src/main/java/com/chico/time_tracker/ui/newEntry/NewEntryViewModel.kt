package com.chico.time_tracker.ui.newEntry

import android.app.Application
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chico.time_tracker.const.ConstantsNewEntry
import com.chico.time_tracker.const.ConstantsSp
import com.chico.time_tracker.db.entity.WorkingTime
import com.chico.time_tracker.sp.GetSP
import com.chico.time_tracker.sp.SetSP
import com.chico.time_tracker.utils.MessageLog
import com.chico.time_tracker.utils.parseDateFromMillisDdMmYyyy
import com.chico.time_tracker.utils.parseTimeFromMillisHhMm

class NewEntryViewModel(
    private val app: Application
) : AndroidViewModel(app) {

    private val spName: String = ConstantsSp.SP_NAME

    private val argsDate: String = ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_DATE_LONG
    private val argsStartWorkingTime: String =
        ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_START_WORKING_TIME_INT
    private val argsEndWorkingTime: String =
        ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_END_WORKING_TIME_INT
    private val argsMoneyPerHour: String = ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_MONEY_PER_HOUR_INT
    private val argsAddress: String = ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_ADDRESS_STRING
    private val argsDescription: String = ConstantsNewEntry.ARGS_NEW_ENTRY_FRAGMENT_DESCRIPTION_STRING

    private val sp = app.getSharedPreferences(spName, MODE_PRIVATE)
    private val spEditor = sp.edit()
    private val getSp = GetSP(sp)
    private val setSP = SetSP(spEditor)

    private val _date = MutableLiveData<String>()
    val date: LiveData<String>
        get() = _date

    private val _startTime = MutableLiveData<String>()
    val startTime: LiveData<String>
        get() = _startTime

    private val _endTime = MutableLiveData<String>()
    val endTime: LiveData<String>
        get() = _endTime

    private val _moneyPerHour = MutableLiveData<Int>()
    val moneyPerHour: LiveData<Int>
        get() = _moneyPerHour

    private val _workHoursInDay = MutableLiveData<Int>()
    val workHoursInDay: LiveData<Int>
        get() = _workHoursInDay

    private val _moneyPerDay = MutableLiveData<Int>()
    val moneyPerDay: LiveData<Int>
        get() = _moneyPerDay

    private val _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description


    init {
        getValuesFromSP()
    }

    private fun getValuesFromSP() {
        _moneyPerHour.value = getSp.getInt(argsMoneyPerHour)
        _date.value = getSp.getLong(argsDate).parseDateFromMillisDdMmYyyy()
        _startTime.value = getSp.getInt(argsStartWorkingTime).toLong().parseTimeFromMillisHhMm()
        _endTime.value = getSp.getInt(argsEndWorkingTime).toLong().parseTimeFromMillisHhMm()
        _address.value = getSp.getString(argsAddress)
        _description.value = getSp.getString(argsDescription)
    }

    fun chekWorkingTime(workingTime: WorkingTime): Boolean {
        return true
    }

    fun saveWorkingTime(workingTime: WorkingTime) {

        saveWorkingTimeToSp(workingTime)

        MessageLog.log(
            "saved...\n" +
                    "date ${workingTime.date}, start time ${workingTime.startTime}, end time ${workingTime.endTime} \n" +
                    "money per hour ${workingTime.moneyPerDay}, work in day ${workingTime.workHoursInDay}, money per day ${workingTime.moneyPerDay}"
        )
    }

    private fun saveWorkingTimeToSp(workingTime: WorkingTime) {
        setSP.putToSp(argsMoneyPerHour,workingTime.moneyPerHour)
        setSP.putToSp(argsDate,workingTime.date)
        setSP.putToSp(argsStartWorkingTime, workingTime.startTime)
        setSP.putToSp(argsEndWorkingTime, workingTime.endTime)
        setSP.putToSp(argsAddress, workingTime.address.toString())
        setSP.putToSp(argsDescription, workingTime.description.toString())
    }

}