package com.example.capstorefinal.presentation.fragments.productScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.data.model.CapModel
import com.example.capstorefinal.databinding.FragmentProductBinding
import com.example.capstorefinal.presentation.adapters.CapsAdapter


class ProductFragment : BaseFragment<BaseViewModel,FragmentProductBinding>() {

    private lateinit var productAdapter:CapsAdapter
    private lateinit var productList:List<CapModel>

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentProductBinding {
        return FragmentProductBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        fullProductList()
        productAdapter = CapsAdapter(productList)
        binding.bestSellerFragmentRv.adapter = productAdapter
    }

    private fun fullProductList() {
        productList = listOf(
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,),
            CapModel(R.drawable.cap_bestsel,"Adidas","окупай одежду и обувь в спортивном магазине adidas! ", 200,)
        )

    }

}