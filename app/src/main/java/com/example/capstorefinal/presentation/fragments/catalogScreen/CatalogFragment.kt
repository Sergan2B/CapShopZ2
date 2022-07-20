package com.example.capstorefinal.presentation.fragments.catalogScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseFragment
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.data.model.CapModel
import com.example.capstorefinal.databinding.FragmentCatalogBinding
import com.example.capstorefinal.presentation.adapters.CapsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton


class CatalogFragment : BaseFragment<BaseViewModel,FragmentCatalogBinding>() {


    private lateinit var bestsellerAdapter : CapsAdapter
    private lateinit var saleAdapter : CapsAdapter
    private lateinit var capList:List<CapModel>
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentCatalogBinding {
        return FragmentCatalogBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        initRecycler()
        initSearch()

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initSearch() {
        binding.searchEt.setOnTouchListener(View.OnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= binding.searchEt.getRight() - binding.searchEt.getCompoundDrawables()
                        .get(DRAWABLE_RIGHT).getBounds().width()
                ) {
                    // sort dialog
                    val dialog =
                        BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
                    val view = layoutInflater.inflate(R.layout.fragment_s_ort, null)
                    val btnClose = view.findViewById<ImageButton>(R.id.close_btn)
                    val btnBuy = view.findViewById<MaterialButton>(R.id.buy_btn)
                    val sortNew = view.findViewById<MaterialButton>(R.id.sort_new_btn)
                    val sortPopular = view.findViewById<MaterialButton>(R.id.popularSortBtn)
                    val sortCheap = view.findViewById<MaterialButton>(R.id.cheap_sort)
                    val sortExpensive = view.findViewById<MaterialButton>(R.id.expensive_sort)


                    sortCheap.setOnClickListener {
                        it.isEnabled = false
                        sortExpensive.isEnabled = true
                        sortPopular.isEnabled = true
                        sortNew.isEnabled = true
                    }

                    sortExpensive.setOnClickListener {
                        it.isEnabled = false
                        sortCheap.isEnabled = true
                        sortPopular.isEnabled = true
                        sortNew.isEnabled = true

                    }

                    sortNew.setOnClickListener {
                        it.isEnabled = false
                        sortCheap.isEnabled = true
                        sortPopular.isEnabled = true
                        sortExpensive.isEnabled = true
                    }
                    sortPopular.setOnClickListener {
                        it.isEnabled = false
                        sortCheap.isEnabled = true
                        sortNew.isEnabled = true
                        sortExpensive.isEnabled = true
                    }

                    btnBuy.setOnClickListener {
                        Toast.makeText(requireContext(), "Sorted", Toast.LENGTH_LONG)
                            .show()
                    }
                    btnClose.setOnClickListener {
                        dialog.dismiss()
                    }
                    dialog.setCancelable(false)
                    dialog.setContentView(view)
                    dialog.show()

                    return@OnTouchListener true
                }
            }
            false
        })
    }

    private fun initRecycler() {
        loadCapList()
        bestsellerAdapter = CapsAdapter(capList)
        bestsellerAdapter.onItemClick = {
            navigateDetailF()
        }
        binding.bestSellersRv.adapter = bestsellerAdapter
        saleAdapter = CapsAdapter(capList)
        saleAdapter.onItemClick = { capModel ->
            navigateDetailF()
        }
        binding.saleRecycler.adapter = saleAdapter
    }

    private fun navigateDetailF() {
        Navigation.findNavController(requireView()).navigate(R.id.detailFragment)
    }


    override fun initListener() {
        super.initListener()
        binding.viewAllBestSellTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.productFragment)
        }
        binding.viewAllSaleTv.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.productFragment)
        }
        binding.newEraBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.productFragment)
        }
    }



    private fun loadCapList() {
        capList = listOf(
            CapModel(R.drawable.cap_pic,"H&M","Good quality caps",100),
            CapModel(R.drawable.cap_pic,"H&M","Good quality caps",100),
            CapModel(R.drawable.cap_pic,"H&M","Good quality caps",100)
        )
    }

}