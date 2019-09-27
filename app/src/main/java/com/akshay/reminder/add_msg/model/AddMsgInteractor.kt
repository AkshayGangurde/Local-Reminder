package com.akshay.reminder.add_msg.model

import androidx.work.*
import com.akshay.reminder._data.room.AppDatabase
import com.akshay.reminder._utilities.MyApplication
import com.akshay.reminder.message_list.model.MessageModel
import java.util.*
import com.akshay.reminder._utilities.NotifyWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.concurrent.TimeUnit


class AddMsgInteractor {

    companion object {
        private val TAG: String = AddMsgInteractor::class.java.simpleName
    }

    interface OnFinishedListener {
        fun onResultSuccess(strResponse: String)
        fun onResultFail(strError: String)
    }

    fun insertMsg(
        onFinishedListener: OnFinishedListener,
        msg: MessageModel,
        reminderTime: Long
    ) {

        try {
            //store DBEventID to pass it to the PendingIntent and open the appropriate event page on notification click
            val inputData = Data.Builder()
                .putInt("ID", msg.uniqueId)
                .putString("Message", msg.message).build()
            GlobalScope.launch {

                AppDatabase.getDatabase()?.getAppDao()?.insertMessage(msg)

                val notificationWork = OneTimeWorkRequest.Builder(NotifyWorker::class.java)
                    .setInitialDelay(reminderTime, TimeUnit.MILLISECONDS)
                    .setInputData(inputData)
                    .addTag(TAG)
                    .build()
                WorkManager.getInstance().enqueue(notificationWork)

                withContext(Dispatchers.Main) {
                    onFinishedListener.onResultSuccess("Record Inserted Successfully!")
                }
            }

        } catch (e: Exception) {
            onFinishedListener.onResultFail("Failed to Insert Record.")
        }
    }
}