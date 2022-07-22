package com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.FirstFragment
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.FourthFragment
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.SecondFragment
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.ThirdFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> FourthFragment()
        }
    }
}