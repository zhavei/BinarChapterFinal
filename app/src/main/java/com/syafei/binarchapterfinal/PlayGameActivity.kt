package com.syafei.binarchapterfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.binarchapterfinal.databinding.ActivityPlayGameBinding

private var binding: ActivityPlayGameBinding? = null

class PlayGameActivity : AppCompatActivity() {

    companion object {
        val NAMECHOOSEN = "_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val intent = intent.getStringExtra(NAMECHOOSEN)
        val greating = "Haloo selamat datang $intent"
        binding?.tvPlayGameActivity?.text = greating


    }
}