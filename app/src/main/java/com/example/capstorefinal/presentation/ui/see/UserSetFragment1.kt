package com.example.capstorefinal.presentation.ui.see

import android.view.LayoutInflater
import androidx.fragment.app.FragmentTransaction
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Item4ProfileNokBinding

class UserSetFragment1 : BaseFragment<Item4ProfileNokBinding>() {
    override fun inflateVB(inflater: LayoutInflater): Item4ProfileNokBinding {
        return Item4ProfileNokBinding.inflate(layoutInflater)
    }

    private val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

    override fun initListener() {
        super.initListener()
        binding.btnEdit.setOnClickListener {
            ft.replace(R.id.profile_nok_container, UserSetFragment2())
            ft.addToBackStack("Key14")
            ft.commit()
        }
    }
}