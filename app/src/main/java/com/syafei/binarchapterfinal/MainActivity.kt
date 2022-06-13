package com.syafei.binarchapterfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.syafei.binarchapterfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguratoion: AppBarConfiguration
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragment_container_view)

        appBarConfiguratoion = AppBarConfiguration(
            setOf(
                R.id.playFragment,
                R.id.leaderboardFragment,
                R.id.historyFragment
            )
        )

        //appBarConfiguratoion = AppBarConfiguration(navController.graph, navigationView)

        //navigationView.setupWithNavController(navController)
        binding.bottomNavigationView.setupWithNavController(navController)


    }
}