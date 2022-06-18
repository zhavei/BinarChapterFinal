package com.syafei.binarchapterfinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafei.binarchapterfinal.databinding.ActivityChooseAnOpponentBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChooseAnOpponentActivity : AppCompatActivity() {

    private val userDummy = listOf(
        User(name = "ronaldo"),
        User(name = "messi"),
        User(name = "neymar")
    )

    private var _binding: ActivityChooseAnOpponentBinding? = null
    private lateinit var binding: ActivityChooseAnOpponentBinding

    private val userChooseAdapter = UserChooseAdapter()

    private val userChooseDatabase: UserChooseDatabase? by lazy {
        UserChooseDatabase.getInstance(this)
    }
    private val userChooseDao: UserChooseDao? by lazy {
        userChooseDatabase?.userChooseDao()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChooseAnOpponentBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)

        setContentView(binding.root)
        setupView()

    }

    private fun setupView() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvChoseOpponent.layoutManager = linearLayoutManager
        binding.rvChoseOpponent.adapter = userChooseAdapter

        binding.btnChoosplayer.setOnClickListener {
            val intent = Intent(this, InsertUserChooseActivity::class.java)
            startActivity(intent)
        }

        //userChooseAdapter.addList(userDummy)
        getUserDatabase()
    }

    private fun getUserDatabase() {
        GlobalScope.launch {
            val userData = userChooseDao?.getAllUser().orEmpty()
            runOnUiThread {
                userChooseAdapter.addList(userData)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getUserDatabase()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
