package com.example.capstorefinal.presentation.fragments.profileScreen

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<BaseViewModel,FragmentProfileBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        binding.editBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.editProfileFragment)
        }
    }



}