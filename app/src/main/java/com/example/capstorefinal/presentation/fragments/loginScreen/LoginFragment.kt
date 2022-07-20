package com.example.capstorefinal.presentation.fragments.loginScreen

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.databinding.FragmentLoginBinding
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel


class LoginFragment : BaseFragment<BaseViewModel,FragmentLoginBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }


    override fun initListener() {
        check()
        super.initListener()
        binding.registerTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }
        binding.restoreTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.restoreFragment)
        }
    }

    private fun check() {
        binding.numberEv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(str: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(str: Editable) {
                if(binding.numberEv.text.toString().isNotEmpty()){
                    binding.loginBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.mainYellow))
                    binding.loginBtn.setOnClickListener {
                        Navigation.findNavController(it).navigate(R.id.catalogFragment)
                    }
                }else{
                    Toast.makeText(requireContext(),"empty", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}