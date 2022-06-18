package com.syafei.binarchapterfinal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.syafei.binarchapterfinal.databinding.ActivityPlayGameBinding

private var binding: ActivityPlayGameBinding? = null

class PlayGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val intent = intent.getStringExtra("_name")
        val greating = "Haloo selamat datang $intent"
        binding?.tvPlayGameActivity?.text = greating


    }
}