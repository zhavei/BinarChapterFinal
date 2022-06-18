package com.syafei.binarchapterfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserChooseAdapter : RecyclerView.Adapter<UserChooseViewHolder>() {

    private val userChooseList: MutableList<UserChoose> = mutableListOf()


    fun addList(list: List<UserChoose>) {
        userChooseList.clear()
        userChooseList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserChooseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view_choose_opponent, parent, false)
        return UserChooseViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserChooseViewHolder, position: Int) {
        val itemUser = userChooseList[position]
        holder.bind(itemUser)
    }

    override fun getItemCount(): Int {
        return userChooseList.size
    }
}