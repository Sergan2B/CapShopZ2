package com.example.capstorefinal.presentation.ui.onceUse

import android.view.LayoutInflater
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.databinding.FragmentDetailBinding
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.presentation.ui.tabLayout.tabFragments.FirstFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    lateinit var model: String

    override fun initView() {
        super.initView()
        getData()
    }

    override fun initListener() {
        super.initListener()
        binding.addBtn.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        /*val toastLayout = layoutInflater.inflate(
            R.layout.toast_custom, activity?.findViewById(R.id.custom_toast_container)
        )
        toastLayout.findViewById<TextView>(R.id.txtvw).text = "Товар добавлен в корзину"
        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = toastLayout
        toast.show()*/

        //Toast.make
    }

    private fun getData() {
        val itemCap = arguments?.getSerializable(FirstFragment.ITEM_KEY1) as Cap
        binding.tvCompanyName.text = itemCap.companyName
        binding.tvSeriesName.text = itemCap.seriesName
        binding.ivBackCap.setImageResource(itemCap.image)
        if (itemCap.statusDiscount) binding.costTv.text = (itemCap.oldCost - 500).toString()
        else binding.costTv.text = itemCap.oldCost.toString()
    }

    override fun inflateVB(inflater: LayoutInflater): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }
}