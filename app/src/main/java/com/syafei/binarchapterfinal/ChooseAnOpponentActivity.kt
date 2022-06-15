package com.syafei.binarchapterfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.binarchapterfinal.databinding.ActivityChooseAnOpponentBinding

class ChooseAnOpponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseAnOpponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseAnOpponentBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}
