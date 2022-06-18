package com.syafei.binarchapterfinal

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.syafei.binarchapterfinal.databinding.ItemRecyclerViewChooseOpponentBinding

class UserChooseViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun bind(user: User) = ItemRecyclerViewChooseOpponentBinding.bind(itemView).run {
        tvItemChooseOpponent.text = user.name

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, PlayGameActivity::class.java).apply {
                putExtra("_name", position)
                putExtra("_name", tvItemChooseOpponent.text)
            }
            itemView.context.startActivity(intent)
        }

    }


}