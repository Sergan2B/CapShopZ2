package com.example.capstorefinal.presentation.activities.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNav()
    }

    private fun initBottomNav() {
        val navController = Navigation.findNavController(this,R.id.my_container)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.catalogFragment ||
                destination.id == R.id.detailFragment ||
                destination.id == R.id.productFragment ||
                        destination.id == R.id.accountFragment||
                        destination.id==R.id.editProfileFragment||
                        destination.id == R.id.orderFragment||
                        destination.id ==R.id.orderDetailFragment
            ) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else {
                binding.bottomNavigation.visibility = View.GONE
            }
        })
    }
}