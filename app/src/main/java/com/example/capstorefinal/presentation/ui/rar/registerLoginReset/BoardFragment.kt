package com.example.capstorefinal.presentation.ui.rar.registerLoginReset

import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment0BoardBinding

class BoardFragment : BaseFragment<Fragment0BoardBinding>() {

    override fun inflateVB(inflater: LayoutInflater): Fragment0BoardBinding {
        return Fragment0BoardBinding.inflate(inflater)
    }

    override fun initListener() {
        binding.loginBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }
        binding.registerBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }
    }

}