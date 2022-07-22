package com.example.capstorefinal.presentation.ui.tabLayout.tabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.extentions.load
import com.example.capstorefinal.core.network.result.Status
import com.example.capstorefinal.databinding.Fragment1HomeBinding
import com.example.capstorefinal.domain.model.Result
import com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter.AdapterForFirstFragment3
import com.example.capstorefinal.presentation.ui.MainViewModel


class FirstFragment : BaseFragment<Fragment1HomeBinding>() {
    private val viewModel: MainViewModel by lazy { ViewModelProvider(requireActivity())[MainViewModel::class.java] }
    private lateinit var adapterMain1: AdapterForFirstFragment3
    private lateinit var adapterMain2: AdapterForFirstFragment3
    private lateinit var adapterMain3: AdapterForFirstFragment3


    override fun inflateVB(inflater: LayoutInflater): Fragment1HomeBinding {
        return Fragment1HomeBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        initSearch()
        initRecyclers()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getBanner().observe(this) {
            when (it.status) {
                Status.ERROR -> {
                    it.msg?.let { it1 ->
                        Toast.makeText(requireContext(), it1, Toast.LENGTH_LONG).show()
                    }
                }
                Status.SUCCESS -> {
                    if (it.data != null) {
                        val image: Result = it.data.results[2]
                        binding.viewBox.load(image.baner)
                    }
                }
                Status.LOADING -> {
                }
            }
        }
    }

    override fun initListener() {
        super.initListener()
        val bundle = Bundle()
        binding.btnImageNewEra.setOnClickListener {
            bundle.putString(KEY1, "New Era")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }
        binding.btnImageAdidas.setOnClickListener {
            bundle.putString(KEY1, "Adidas")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }
        binding.btnImageNike.setOnClickListener {
            bundle.putString(KEY1, "Nike")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }
        binding.btnImageVans.setOnClickListener {
            bundle.putString(KEY1, "Vans")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }

        binding.btnLinkYet.setOnClickListener {
            bundle.putString(KEY1, "bestsellers")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }
        binding.btnLinkYet2.setOnClickListener {
            bundle.putString(KEY1, "discount")
            findNavController().navigate(R.id.uniSelectFragment, bundle)
        }

        adapterMain1.onCapItemClickListener = {
            bundle.putSerializable(ITEM_KEY1, it)
            findNavController().navigate(R.id.detailFragment, bundle)
        }
        adapterMain2.onCapItemClickListener = {
            bundle.putSerializable(ITEM_KEY1, it)
            findNavController().navigate(R.id.detailFragment, bundle)
        }
        adapterMain3.onCapItemClickListener = {
            bundle.putSerializable(ITEM_KEY1, it)
            findNavController().navigate(R.id.detailFragment, bundle)
        }
    }

    private fun initSearch() {

    }

    private fun initRecyclers() {
        adapterMain1 = AdapterForFirstFragment3()
        adapterMain2 = AdapterForFirstFragment3()
        adapterMain3 = AdapterForFirstFragment3()

        binding.recyclerViewBestsellers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewDiscount.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewAll.layoutManager = GridLayoutManager(requireContext(), 2)

        binding.recyclerViewBestsellers.adapter = adapterMain1
        binding.recyclerViewDiscount.adapter = adapterMain2
        binding.recyclerViewAll.adapter = adapterMain3
    }

    override fun initObserver() {
        viewModel.capListLD.observe(this) { itList ->
            val (correct1, _) = itList.partition { it.statusBestsellers }
            val (correct2, _) = itList.partition { it.statusDiscount }
            adapterMain1.submitList(correct1)
            adapterMain2.submitList(correct2)
            adapterMain3.submitList(itList)
        }
    }

    companion object {
        const val KEY1 = "key1"
        const val ITEM_KEY1 = "item key1"
    }
}