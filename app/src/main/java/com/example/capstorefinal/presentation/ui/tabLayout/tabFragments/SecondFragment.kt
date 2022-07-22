package com.example.capstorefinal.presentation.ui.tabLayout.tabFragments

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment2CartBinding
import com.example.capstorefinal.presentation.ui.MainViewModel

class SecondFragment : BaseFragment<Fragment2CartBinding>() {
    val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }

    override fun inflateVB(inflater: LayoutInflater): Fragment2CartBinding {
        return Fragment2CartBinding.inflate(inflater)
    }

    override fun initView() {
    }

    override fun initListener() {
    }
}