package com.chico.time_tracker.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "working_time_table")
data class WorkingTime(
    @ColumnInfo(name = "date")
    val date:Long,
    @ColumnInfo(name = "start_time")
    val startTime:Int,
    @ColumnInfo(name = "end_time")
    val endTime:Int,
    @ColumnInfo(name = "work_hours_in_day")
    val workHoursInDay:Int,
    @ColumnInfo(name = "money_per_hour")
    val moneyPerHour:Int,
    @ColumnInfo(name = "money_per_day")
    val moneyPerDay:Int,
    @ColumnInfo(name = "address")
    val address:String?,
    @ColumnInfo(name = "description")
    val description:String?,
    @ColumnInfo(name = "coordinates")
    val coordinates:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Long?=null
}
