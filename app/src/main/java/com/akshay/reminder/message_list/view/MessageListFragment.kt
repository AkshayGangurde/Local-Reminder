package com.akshay.reminder.message_list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.akshay.reminder.BaseInterface
import com.akshay.reminder.databinding.FragmentMessageListBinding
import com.akshay.reminder.message_list.model.MsgListAdapter
import com.akshay.reminder.message_list.model.MsgListInteractor
import com.akshay.reminder.message_list.presenter.MsgListPresenter
import com.mahindra.kmsga.utils.showToast
import kotlinx.coroutines.launch

class MessageListFragment : Fragment(), BaseInterface.View {

    private lateinit var msgListPresenter: MsgListPresenter
    private lateinit var binding: FragmentMessageListBinding
    private var exit = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageListBinding.inflate(inflater, container, false)

        initObserver()

        // Inflate the layout for this fragment
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (exit) {
                activity?.finishAndRemoveTask()
            } else {
                activity?.showToast("Press back again to exit.")
                exit = true
                lifecycleScope.launch {
                    kotlinx.coroutines.delay(3000)
                    exit = false
                }
            }
        }
        callback.isEnabled = true

        return binding.root
    }

    private fun initObserver() {
        msgListPresenter = MsgListPresenter(this, MsgListInteractor())
        msgListPresenter.getAllMessages()
        msgListPresenter.msgsList.observe(this, Observer {
            binding.adapter = MsgListAdapter(it)
        })
    }

    override fun onResume() {
        super.onResume()
//        msgListPresenter = MsgListPresenter(this, MsgListInteractor())
//        msgListPresenter.getAllMessages()
//        msgListPresenter.msgsList.observe(this, Observer {
//            binding.adapter = MsgListAdapter(it)
//        })

    }

    override fun showMessage(message: String) {
        activity?.showToast(message)
    }

    override fun showError(error: String) {
        activity?.showToast(error)
    }
}