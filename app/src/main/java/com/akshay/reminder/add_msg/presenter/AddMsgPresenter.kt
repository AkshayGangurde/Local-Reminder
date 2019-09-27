package com.akshay.reminder.add_msg.presenter

import com.akshay.reminder.add_msg.model.AddMsgInteractor
import com.akshay.reminder.BaseInterface
import com.akshay.reminder.message_list.model.MessageModel
import java.text.SimpleDateFormat
import java.util.*
import androidx.databinding.ObservableField



class AddMsgPresenter(
    private val addMessageInterface: BaseInterface.View,
    private val addMsgInteractor: AddMsgInteractor
) : AddMsgInteractor.OnFinishedListener {

    fun insertMsg(
        message: String,
        hh: String,
        mm: String,
        am_pm: Int,
        isShown: Boolean
    ) {
        //Validation
        when {
            message == "" -> {
                addMessageInterface.showMessage("Please add message")
                return
            }
            hh == "" -> {
                addMessageInterface.showMessage("Please add hours")
                return
            }
            mm == "" -> {
                addMessageInterface.showMessage("Please add minutes")
                return
            }
        }

        val calReminderTime = Calendar.getInstance()
        calReminderTime.set(Calendar.HOUR_OF_DAY, hh.toInt())
        calReminderTime.set(Calendar.MINUTE, mm.toInt())
        calReminderTime.set(Calendar.SECOND, 0)

        calReminderTime.set(Calendar.AM_PM, am_pm)

        val calCurrentTime = Calendar.getInstance()
        calCurrentTime .set(Calendar.SECOND, 0)
        calCurrentTime.set(Calendar.MILLISECOND, 0)

        val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val strTime = dateFormat.format(calReminderTime.time)

        val reminderTime = (calReminderTime.timeInMillis - calCurrentTime.timeInMillis)

        //Create message data object
        val msg = MessageModel(null, 0, message, strTime, isShown)

        addMsgInteractor.insertMsg(this, msg, reminderTime)
    }

    override fun onResultSuccess(strResponse: String) {
        addMessageInterface.showMessage(strResponse)
    }

    override fun onResultFail(strError: String) {
        addMessageInterface.showError(strError)
    }
}