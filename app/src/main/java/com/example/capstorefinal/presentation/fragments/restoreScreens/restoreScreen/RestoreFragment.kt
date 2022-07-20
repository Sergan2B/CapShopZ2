package com.example.capstorefinal.presentation.fragments.restoreScreens.restoreScreen

import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.FragmentRestoreBinding
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel

class RestoreFragment : BaseFragment<BaseViewModel,FragmentRestoreBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentRestoreBinding {
        return FragmentRestoreBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()
        binding.restoreBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.smsFragment)
        }
    }

}