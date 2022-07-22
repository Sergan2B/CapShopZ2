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
import com.example.capstorefinal.databinding.Fragment0RegisterBinding

class RegisterFragment : BaseFragment<Fragment0RegisterBinding>() {

    override fun inflateVB(inflater: LayoutInflater): Fragment0RegisterBinding =
        Fragment0RegisterBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        check()
    }

    private fun check() {
        binding.nameEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(str: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(str: Editable) {
                if (binding.nameEt.text.toString().isNotEmpty()) {
                    binding.registerBtn.setBackgroundColor(ContextCompat.getColor(requireContext(),
                        R.color.yellow))
                    binding.btnFacebookAndGoogle.visibility = View.GONE
                    binding.orRl.visibility = View.GONE
                    binding.haveAccountLl.visibility = View.VISIBLE
                } else {
                    Toast.makeText(requireContext(), "empty", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun initListener() {
        binding.loginRTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }
    }
}