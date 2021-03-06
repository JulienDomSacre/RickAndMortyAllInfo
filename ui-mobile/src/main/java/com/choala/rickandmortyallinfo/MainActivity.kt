package com.choala.rickandmortyallinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        supportFragmentManager.findFragmentById(R.id.navHostFragment)
            ?.findNavController()
            ?.let { navController -> bnv_main.setupWithNavController(navController = navController) }
    }
}