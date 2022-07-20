package com.example.capstorefinal.presentation.fragments.orderDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.databinding.FragmentOrderDetailBinding


class OrderDetailFragment : BaseFragment<BaseViewModel,FragmentOrderDetailBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentOrderDetailBinding {
        return FragmentOrderDetailBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
        
    }


}