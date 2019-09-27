package com.akshay.reminder._data.room

import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akshay.reminder._utilities.MyApplication
import com.akshay.reminder.message_list.model.MessageModel

@Database(entities = [MessageModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        @VisibleForTesting
        private val DB_NAME = "Reminder_db"

        fun getDatabase(): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        MyApplication.ctx!!,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }
            return INSTANCE
        }
    }


}