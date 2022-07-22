package com.example.capstorefinal.presentation.ui.onceUse

import android.view.LayoutInflater
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.FragmentCartBinding

class CartFragment : BaseFragment<FragmentCartBinding>() {

    lateinit var adapter: CartAdapter

    override fun initView() {
        super.initView()
        loadData()
        initRecyclers()
    }

    private fun loadData() {

    }

    private fun initRecyclers() {
        adapter = CartAdapter()
    }


    override fun inflateVB(inflater: LayoutInflater): FragmentCartBinding {
        return FragmentCartBinding.inflate(layoutInflater)
    }
}
