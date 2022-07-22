package com.example.capstorefinal

import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.FragmentUserSetBinding

class UserSetFragment : BaseFragment<FragmentUserSetBinding>() {
    override fun inflateVB(inflater: LayoutInflater): FragmentUserSetBinding {
        return FragmentUserSetBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        val key = bundleOf().getString(USER_KEY)
        when (key) {
            "profile setting" -> {

            }
            "my orders" -> {}
            "my address" -> {}
        }
    }

    companion object {
        const val USER_KEY = "screen for work"
    }
}