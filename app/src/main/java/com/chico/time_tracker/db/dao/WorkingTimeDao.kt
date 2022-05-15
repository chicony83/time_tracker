package com.chico.time_tracker.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chico.time_tracker.db.entity.WorkingTime

@Dao
interface WorkingTimeDao {
    @Insert
    suspend fun addNewEntryOfWorkingTime(workingTime: WorkingTime):Long

    @Query("SELECT * FROM working_time_table")
    suspend fun getAllEntries():List<WorkingTime>
}