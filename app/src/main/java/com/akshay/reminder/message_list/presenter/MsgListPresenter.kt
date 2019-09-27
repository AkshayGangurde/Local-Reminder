package com.akshay.reminder.message_list.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.akshay.reminder.BaseInterface
import com.akshay.reminder.message_list.model.MessageModel
import com.akshay.reminder.message_list.model.MsgListInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MsgListPresenter(
    private val msgListInterface: BaseInterface.View,
    private val msgListInteractor: MsgListInteractor
) : MsgListInteractor.OnFinishedListener {

    var msgsList: LiveData<List<MessageModel>> = MutableLiveData()
    val context = this

    fun getAllMessages() {

        msgsList = msgListInteractor.getAllMessages(context)

    }

    override fun onResultSuccess(strResponse: String) {
        msgListInterface.showMessage(strResponse)
    }

    override fun onResultFail(strError: String) {
        msgListInterface.showError(strError)
    }

}