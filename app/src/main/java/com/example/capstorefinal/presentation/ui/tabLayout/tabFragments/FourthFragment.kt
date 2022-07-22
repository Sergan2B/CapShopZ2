package com.example.capstorefinal.presentation.ui.tabLayout.tabFragments

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment4UserBinding
import com.example.capstorefinal.presentation.ui.MainViewModel

class FourthFragment : BaseFragment<Fragment4UserBinding>() {

    val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }


    override fun inflateVB(inflater: LayoutInflater): Fragment4UserBinding {
        return Fragment4UserBinding.inflate(inflater)
    }

    override fun initView() {
    }

    override fun initListener() {
        binding.profile.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.userSetFragment1)
        }
    }
}