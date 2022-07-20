package com.example.capstorefinal.presentation.fragments.detailScreen

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.data.model.CapModel
import com.example.capstorefinal.databinding.FragmentDetailBinding
import com.example.capstorefinal.presentation.adapters.CapsAdapter
import com.google.android.material.tabs.TabLayoutMediator


class DetailFragment : BaseFragment<BaseViewModel,FragmentDetailBinding>() {

    private lateinit var similarAdapter:CapsAdapter
    private lateinit var viewPagerAdapter:ViewPagerAdapter
    private lateinit var similarList: ArrayList<CapModel>

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        initRecycler()
        initViewPager()
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerAdapter(fullImageList())
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ){ _,_->}.attach()

    }

    private fun fullImageList():List<Int> {
        return arrayListOf(
            R.drawable.cap1,
            R.drawable.cap2,
            R.drawable.cap3,
            R.drawable.cap4,
        )
    }

    override fun initListener() {
        super.initListener()
        binding.addBtn.setOnClickListener {
            showDialog()
        }
    }


    private fun initRecycler() {
        fullList()
        similarAdapter = CapsAdapter(similarList)
        binding.similarRecycler.adapter = similarAdapter
    }



    private fun fullList() {
        similarList = ArrayList()

        for (i in 1..10){
            similarList.add(CapModel(R.drawable.cap_bestsel,"Linig","blablablabla",300))
        }

    }


    private fun showDialog() {
        val toastLayout = layoutInflater.inflate(
            R.layout.toast_custom,activity?.findViewById(R.id.custom_toast_container)
        )
        toastLayout.findViewById<TextView>(R.id.txtvw).text = "Товар добавлен в корзину"
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = toastLayout
        toast.show()
    }
}