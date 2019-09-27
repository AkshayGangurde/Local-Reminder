package com.akshay.reminder.message_list.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_master")
data class MessageModel(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "uniqueId") var uniqueId: Int,
    @ColumnInfo(name = "message") var message: String,
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "isShown") var isShown: Boolean
)