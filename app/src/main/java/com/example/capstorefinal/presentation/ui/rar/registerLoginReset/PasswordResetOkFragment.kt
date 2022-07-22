package com.example.capstorefinal.presentation.ui.rar.registerLoginReset

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment0PasswordResetOkBinding

class PasswordResetOkFragment : BaseFragment<Fragment0PasswordResetOkBinding>() {

    override fun initListener() {
        super.initListener()
        binding.passwordConfirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(str: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(str: Editable) {
                /*val newPassword = binding.passwordNew.text.toString()
                val newConfirm = binding.passwordNew.text.toString()
                if (newPassword == newConfirm && newConfirm.isNotEmpty() && newPassword.isNotEmpty()) {

                } else {
                    Toast.makeText(requireContext(), "empty", Toast.LENGTH_LONG).show()
                }*/
            }
        })
    }

    override fun inflateVB(inflater: LayoutInflater): Fragment0PasswordResetOkBinding {
        return Fragment0PasswordResetOkBinding.inflate(inflater)
    }
}