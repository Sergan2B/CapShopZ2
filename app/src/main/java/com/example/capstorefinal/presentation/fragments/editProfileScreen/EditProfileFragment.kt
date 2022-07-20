package com.example.capstorefinal.presentation.fragments.editProfileScreen

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
import com.example.capstorefinal.databinding.FragmentEditProfileBinding

class EditProfileFragment : BaseFragment<BaseViewModel,FragmentEditProfileBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentEditProfileBinding {
      return  FragmentEditProfileBinding.inflate(inflater)
    }

    override fun initListener() {
        super.initListener()
        binding.editVerifyBtn.setOnClickListener {
            showDialog()
        }
    }


    private fun showDialog() {
        val toastLayout = layoutInflater.inflate(
            R.layout.toast_custom,activity?.findViewById(R.id.custom_toast_container)
        )
        toastLayout.findViewById<TextView>(R.id.txtvw).text = "Вы изменили данные"
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = toastLayout
        toast.show()
    }


}