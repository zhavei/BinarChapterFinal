package com.syafei.binarchapterfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.syafei.binarchapterfinal.databinding.ActivityMainBinding
import com.syafei.binarchapterfinal.fragment.HistoryFragment
import com.syafei.binarchapterfinal.fragment.LeaderboardFragment
import com.syafei.binarchapterfinal.fragment.PlayFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val leaderboarFragment = LeaderboardFragment()
    private val historyFragment = HistoryFragment()
    private val playFragmnet = PlayFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(playFragmnet)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_first_fragment -> replaceFragment(playFragmnet)
                R.id.menu_second_fragment -> replaceFragment(leaderboarFragment)
                R.id.menu_trird_Fragment -> replaceFragment(historyFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, fragment)
            transaction.commit()
        }
    }
}