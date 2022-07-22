package com.example.capstorefinal.presentation.ui.see

import android.view.LayoutInflater
import androidx.fragment.app.FragmentTransaction
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Item4ProfileOkBinding

class UserSetFragment2 : BaseFragment<Item4ProfileOkBinding>() {
    override fun inflateVB(inflater: LayoutInflater): Item4ProfileOkBinding {
        return Item4ProfileOkBinding.inflate(layoutInflater)
    }

    private val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

    override fun initListener() {
        super.initListener()
        binding.btnEdit.setOnClickListener {
        }
    }
}