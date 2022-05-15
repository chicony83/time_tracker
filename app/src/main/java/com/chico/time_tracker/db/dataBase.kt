package com.chico.time_tracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chico.time_tracker.db.dao.WorkingTimeDao
import com.chico.time_tracker.db.entity.WorkingTime

@Database(
    entities = [
        WorkingTime::class
    ],
    version = 1,
    exportSchema = true
)
abstract class DataBase:RoomDatabase(){
    abstract fun workingTimeDao():WorkingTimeDao
}

object dataBase{
    fun getDataBase(ctx:Context) =
        Room.databaseBuilder(
            ctx,DataBase::class.java,
            "DataBase"
        )
            .build()
}