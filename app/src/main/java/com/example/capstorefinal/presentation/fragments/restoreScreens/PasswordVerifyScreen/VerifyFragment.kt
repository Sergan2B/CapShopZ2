package com.example.capstorefinal.presentation.fragments.restoreScreens.PasswordVerifyScreen

import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.FragmentVerifyBinding
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel


class VerifyFragment : BaseFragment<BaseViewModel,FragmentVerifyBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentVerifyBinding {
        return FragmentVerifyBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        super.initListener()
        binding.restoreBtn.setOnClickListener {
            showDialog()
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }
    }

    private fun showDialog() {
        val toastLayout = layoutInflater.inflate(
            R.layout.toast_custom,activity?.findViewById(R.id.custom_toast_container)
        )
        toastLayout.findViewById<TextView>(R.id.txtvw).text = "Вы обновили пароль"
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = toastLayout
        toast.show()
    }

}