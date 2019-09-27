package com.akshay.reminder._data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akshay.reminder.message_list.model.MessageModel

@Dao
interface AppDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(model: MessageModel)

    @Query("select * from message_master where isShown = :value")
    fun getAllMessages(value: Boolean): LiveData<List<MessageModel>>

    @Query("update message_master SET isShown =:value where uniqueId = :ID")
    suspend fun updateMsgFlag(value: Boolean, ID: Int)

    @Query("DELETE from message_master")
    suspend fun deleteAll()
}
