package com.example.capstorefinal.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM: BaseViewModel,VB:ViewBinding>: Fragment() {

     protected lateinit var binding: VB
     protected lateinit var viewModel: VM
     protected abstract fun inflateViewBinding(inflater:LayoutInflater):VB


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(layoutInflater)

        initViewModel()
        initView()
        initListener()

        return binding.root


    }

     open fun initListener() {}
     open fun initView() {}
     open fun initViewModel() {}


 }