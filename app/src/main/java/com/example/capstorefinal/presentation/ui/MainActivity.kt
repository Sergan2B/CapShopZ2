package com.example.capstorefinal.presentation.ui

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseActivity
import com.example.capstorefinal.databinding.ActivityMainBinding
import com.example.capstorefinal.utils.Prefs


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private var checkBoolean: Boolean = false
    override val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private lateinit var navController: NavController

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        initBottomNav()
        checkBoolean = true
    }

    private fun initBottomNav() {
        val navController = findNavController(R.id.nav_host_main)


        if (!Prefs(this).isShown()) {
            navController.navigate(R.id.boardFragment2)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.boardFragment2) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}