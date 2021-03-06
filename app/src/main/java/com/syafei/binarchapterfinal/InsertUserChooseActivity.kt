package com.syafei.binarchapterfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.syafei.binarchapterfinal.databinding.ActivityInsertUserChooseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InsertUserChooseActivity : AppCompatActivity() {

    private var _binding: ActivityInsertUserChooseBinding? = null
    private lateinit var binding: ActivityInsertUserChooseBinding

    private val userChooseDatabase: UserChooseDatabase? by lazy {
        UserChooseDatabase.getInstance(this)
    }

    private val userChooseDao: UserChooseDao? by lazy {
        userChooseDatabase?.userChooseDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityInsertUserChooseBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        setupView()

    }

    private fun setupView() {
        binding.btnUserInsertChoose.setOnClickListener {
            val name: String = binding.etUserInsertChose.text.toString()

            val newChoiseUser = UserChoose(
                name = name
            )

            saveToDatabase(newChoiseUser)

            val intent = Intent(this, PlayGameActivity::class.java)
            intent.putExtra(PlayGameActivity.NAMECHOOSEN, newChoiseUser.name)
            Toast.makeText(this, "Halo Selamat Datang ${newChoiseUser.name}", Toast.LENGTH_SHORT)
                .show()
            startActivity(intent)
            finish()
        }
    }

    private fun saveToDatabase(userChoose: UserChoose) {

        GlobalScope.launch {
            val addUser = userChooseDao?.addUser(userChoose)
            println("new added userChoose ---> $addUser")

            runOnUiThread {
                binding.etUserInsertChose.setText("")
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}