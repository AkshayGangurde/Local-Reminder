package com.akshay.reminder.message_list.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.WorkManager
import com.akshay.reminder._data.room.AppDatabase
import com.akshay.reminder._utilities.MyApplication
import com.akshay.reminder.add_msg.model.AddMsgInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MsgListInteractor {

    companion object {
        private val TAG: String = MsgListInteractor::class.java.simpleName
    }

    interface OnFinishedListener {
        fun onResultSuccess(strResponse: String)
        fun onResultFail(strError: String)
    }

     fun getAllMessages(onFinishedListener: OnFinishedListener): LiveData<List<MessageModel>> {
//        try {

            val msgList: LiveData<List<MessageModel>>? =
                AppDatabase.getDatabase()?.getAppDao()?.getAllMessages(true)

            return msgList as LiveData<List<MessageModel>>
//        } catch (e: Exception) {
//            onFinishedListener.onResultFail("Failed to Insert Record.")
//        }
    }
}