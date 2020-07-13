package com.soo.github.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.soo.github.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.product_nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupToolbar()
    }

    private fun setupToolbar() = with(toolbar) {
        setupWithNavController(navController, appBarConfiguration)
        setNavigationOnClickListener {
            navController.navigate(R.id.action_detail_to_main)
        }
    }
}
