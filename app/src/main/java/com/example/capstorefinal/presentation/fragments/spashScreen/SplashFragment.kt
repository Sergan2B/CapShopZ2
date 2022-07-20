package com.example.capstorefinal.presentation.fragments.spashScreen

import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.FragmentSplashBinding
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel


class SplashFragment : BaseFragment<BaseViewModel,FragmentSplashBinding>() {


    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSplashBinding {
      return FragmentSplashBinding.inflate(inflater)
    }


    override fun initListener() {
        super.initListener()
        binding.registerBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }
        binding.loginBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }
    }


}