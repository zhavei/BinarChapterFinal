package com.syafei.binarchapterfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserChooseAdapter : RecyclerView.Adapter<UserChooseViewHolder>() {

    private val userList: MutableList<User> = mutableListOf()


    fun addList(list: List<User>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserChooseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view_choose_opponent, parent, false)
        return UserChooseViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserChooseViewHolder, position: Int) {
        val itemUser = userList[position]
        holder.bind(itemUser)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}