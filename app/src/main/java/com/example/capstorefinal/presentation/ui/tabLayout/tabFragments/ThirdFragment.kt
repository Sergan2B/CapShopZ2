package com.example.capstorefinal.presentation.ui.tabLayout.tabFragments

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment3HeartBinding
import com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter.AdapterForFirstFragment3
import com.example.capstorefinal.presentation.ui.MainViewModel

class ThirdFragment : BaseFragment<Fragment3HeartBinding>() {
    private val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }
    private lateinit var adapterMain: AdapterForFirstFragment3

    override fun inflateVB(inflater: LayoutInflater): Fragment3HeartBinding {
        return Fragment3HeartBinding.inflate(inflater)
    }

    override fun initView() {
        initRecycler()
    }

    override fun initListener() {
    }

    private fun initRecycler() {
        adapterMain = AdapterForFirstFragment3()
        binding.recyclerViewArgument.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewArgument.adapter = adapterMain
    }

    override fun initObserver() {
        viewModel.capListLD.observe(this) {
            val str = arguments?.getString("null")
            when (str) {
                "favourites" -> {
                    for (i in 0..it.lastIndex) {
                        if (!it[i].statusFavourites) adapterMain.submitList(it)
                    }
                }
                "bestsellers" -> {
                    for (i in 0..it.lastIndex) {
                        adapterMain.submitList(it)
                    }
                }
                "discount" -> {
                    for (i in 0..it.lastIndex) {
                        if (it[i].statusDiscount) adapterMain.submitList(it)
                    }
                }
            }
        }
    }
}