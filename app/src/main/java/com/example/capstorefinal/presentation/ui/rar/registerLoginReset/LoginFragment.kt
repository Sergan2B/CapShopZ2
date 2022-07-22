package com.example.capstorefinal.presentation.ui.rar.registerLoginReset

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.Fragment0LoginBinding


class LoginFragment : BaseFragment<Fragment0LoginBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        check()
    }

    private fun check() {
        binding.numberEv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(str: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(str: Editable) {
                if (binding.numberEv.text.toString().isNotEmpty()) {
                    binding.loginBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.yellow))
                    binding.loginBtn.setOnClickListener {
                        Navigation.findNavController(it).navigate(R.id.tabFragment)

                    }
                } else {
                    Toast.makeText(requireContext(), "empty", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun initListener() {
        binding.registerTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }
        binding.restoreTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.passwordResetFragment)
        }

    }

    override fun inflateVB(inflater: LayoutInflater): Fragment0LoginBinding =
        Fragment0LoginBinding.inflate(layoutInflater)
}