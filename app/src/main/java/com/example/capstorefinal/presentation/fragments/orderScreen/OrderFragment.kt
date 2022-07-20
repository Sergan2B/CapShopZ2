package com.example.capstorefinal.presentation.fragments.orderScreen

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.data.model.OrderModel
import com.example.capstorefinal.databinding.FragmentOrderBinding

class OrderFragment : BaseFragment<BaseViewModel,FragmentOrderBinding>() {
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var oList: ArrayList<OrderModel>
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentOrderBinding {
        return FragmentOrderBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        initRecycler()
    }


    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

    private fun initRecycler() {
        orderAdapter = OrderAdapter(fullList())
        orderAdapter.onItemCLick = {

            Navigation.findNavController(requireView()).navigate(R.id.orderDetailFragment)
        }
        binding.orderRecycler.adapter = orderAdapter
    }

    private fun fullList(): MutableList<OrderModel> {
        oList = ArrayList()
        for (i in 1..10) {
            oList.add(OrderModel("00000$i", 210120, "Доставлен"))
        }
        return oList
    }

}