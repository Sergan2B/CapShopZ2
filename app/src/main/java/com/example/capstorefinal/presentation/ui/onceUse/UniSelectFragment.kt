package com.example.capstorefinal.presentation.ui.onceUse

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.FragmentUniSelectBinding
import com.example.capstorefinal.presentation.ui.MainViewModel
import com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter.AdapterForFirstFragment3
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.FirstFragment.Companion.KEY1


class UniSelectFragment : BaseFragment<FragmentUniSelectBinding>() {

    private val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }
    private lateinit var adapterMain1: AdapterForFirstFragment3

    override fun initView() {
        super.initView()
        initRecycler()
    }


    private fun initRecycler() {
        adapterMain1 = AdapterForFirstFragment3()
        binding.recyclerViewArgument.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewArgument.adapter = adapterMain1
    }

    override fun initObserver() {
        val key = arguments?.getString(KEY1)
        viewModel.capListLD.observe(this) { itList ->
            when (key) {
                "New Era" -> {
                    /* val numbers = listOf(1, 2, 3, 4, 5, 6)
                     val (match, rest) = numbers.partition { it > 3 }

                     Toast.makeText(requireContext(), match.toString(), Toast.LENGTH_LONG).show()
                     //условие выполняется
                     Toast.makeText(requireContext(), rest.toString(), Toast.LENGTH_LONG).show()
                     //условие не выполняется*/
                    val (correct, _) = itList.partition { it.companyName == "New Era" }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "New Era"
                }
                "Adidas" -> {
                    val (correct, _) = itList.partition { it.companyName == "Adidas" }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "Adidas"
                }
                "Nike" -> {
                    val (correct, _) = itList.partition { it.companyName == "Nike" }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "Nike"
                }
                "Vans" -> {
                    val (correct, _) = itList.partition { it.companyName == "Vans" }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "Vans"
                }
                "bestsellers" -> {
                    val (correct, _) = itList.partition { it.statusBestsellers }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "Бестселлеры"
                }
                "discount" -> {
                    val (correct, _) = itList.partition { it.statusDiscount }
                    adapterMain1.submitList(correct)
                    binding.tvName.text = "Акции"
                }
            }
        }
    }

    override fun inflateVB(inflater: LayoutInflater): FragmentUniSelectBinding {
        return FragmentUniSelectBinding.inflate(layoutInflater)
    }
}