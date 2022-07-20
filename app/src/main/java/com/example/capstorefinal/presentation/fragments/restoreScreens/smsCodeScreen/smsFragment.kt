package com.example.capstorefinal.presentation.fragments.restoreScreens.smsCodeScreen

import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.FragmentSmsBinding
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel


class smsFragment : BaseFragment<BaseViewModel,FragmentSmsBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSmsBinding {
      return FragmentSmsBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()

        binding.restoreBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.verifyFragment)
        }

    }

}