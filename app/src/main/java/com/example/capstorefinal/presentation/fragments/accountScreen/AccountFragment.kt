package com.example.capstorefinal.presentation.fragments.accountScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.databinding.FragmentAccountBinding


class AccountFragment : BaseFragment<BaseViewModel,FragmentAccountBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentAccountBinding {
        return FragmentAccountBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()
        binding.profileTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.profileFragment)
        }

        binding.ordersTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.orderFragment)
        }
    }

}