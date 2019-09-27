package com.akshay.reminder.add_msg.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akshay.reminder.BaseInterface
import com.akshay.reminder.add_msg.model.AddMsgInteractor
import com.akshay.reminder.add_msg.presenter.AddMsgPresenter
import com.akshay.reminder.databinding.FragmentAddMessageBinding
import com.mahindra.kmsga.utils.showToast

class AddMessageFragment : Fragment(), BaseInterface.View{

    private lateinit var addMsgPresenter: AddMsgPresenter
    private lateinit var binding: FragmentAddMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentAddMessageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        addMsgPresenter = AddMsgPresenter(this, AddMsgInteractor())
        binding.addMsgFrag= this
    }

    fun onSaveClick() {
        addMsgPresenter.insertMsg(
            binding.etAddMsg.text.toString(),
            binding.etHh.text.toString(),
            binding.etMm.text.toString(),
            binding.spinAmPm.selectedItemPosition,
            false
        )
    }

    override fun showMessage(message: String) {
        activity?.showToast(message)
    }

    override fun showError(error: String) {
        activity?.showToast(error)
    }

}