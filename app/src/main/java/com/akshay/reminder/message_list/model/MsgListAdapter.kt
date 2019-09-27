package com.akshay.reminder.message_list.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akshay.reminder.databinding.ItemReminderBinding

class MsgListAdapter(var msgList: List<MessageModel>?) :
    RecyclerView.Adapter<MsgListAdapter.MsgListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgListViewHolder {

        return MsgListViewHolder(ItemReminderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = msgList?.size ?: 0

    override fun onBindViewHolder(holder: MsgListViewHolder, position: Int) {
        holder.binding.msg = msgList!![position]
    }

    class MsgListViewHolder(var binding: ItemReminderBinding) :
        RecyclerView.ViewHolder(binding.root)
}