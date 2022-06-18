package com.syafei.binarchapterfinal

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.syafei.binarchapterfinal.databinding.ItemRecyclerViewChooseOpponentBinding

class UserChooseViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun bind(user: User) = ItemRecyclerViewChooseOpponentBinding.bind(itemView).run {
        tvItemChooseOpponent.text = user.name

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, PlayGameActivity::class.java).apply {
                putExtra(PlayGameActivity.NAMECHOOSEN, position)
                putExtra(PlayGameActivity.NAMECHOOSEN, tvItemChooseOpponent.text)
            }
            Toast.makeText(itemView.context, "Halo Selamat Datang ${user.name}", Toast.LENGTH_SHORT)
                .show()

            itemView.context.startActivity(intent)
        }

    }


}