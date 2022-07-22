package com.example.capstorefinal.presentation.ui.tabLayout

import android.view.LayoutInflater
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.extentions.setIconAlpha
import com.example.capstorefinal.databinding.FragmentTabBinding
import com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabFragment : BaseFragment<FragmentTabBinding>() {
    override fun inflateVB(inflater: LayoutInflater): FragmentTabBinding {
        return FragmentTabBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        initViewPager()
        initTabLayout()
    }


    private fun initTabLayout() {
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.black_home)
                }
                1 -> {
                    tab.setIcon(R.drawable.black_cart)
                    setIconAlpha(tab, 70)
                }
                2 -> {
                    tab.setIcon(R.drawable.black_heart)
                    setIconAlpha(tab, 70)
                }
                else -> {
                    tab.setIcon(R.drawable.black_user)
                    setIconAlpha(tab, 70)
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setIconAlpha(tab, 250)
                // tab.setIcon(R.drawable.ic_button_click)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                setIconAlpha(tab, 70)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun initViewPager() {
        binding.viewPager2.adapter = PagerAdapter(requireActivity())
    }
}