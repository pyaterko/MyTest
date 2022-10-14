package com.owl_laugh_at_wasted_time.mytest.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.owl_laugh_at_wasted_time.mytest.R
import com.owl_laugh_at_wasted_time.mytest.databinding.FragmentMainBinding
import com.owl_laugh_at_wasted_time.mytest.databinding.LoadingStateBinding
import com.owl_laugh_at_wasted_time.mytest.presentation.base.*
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.CategoryRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.DiscountRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.OrderRVAdapter
import kotlinx.coroutines.launch

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val bindingLoading by viewBinding(LoadingStateBinding::bind)
    private val viewModel by viewModels<MainFragmentViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val discountAdapter = DiscountRVAdapter()
        val ordefAdapter = OrderRVAdapter()
        val categoryAdapter = CategoryRVAdapter()

        if (getConnectionType(requireContext()) > 0) {
            viewModel.getData()
        } else {
            viewLifecycleOwner.lifecycleScope.launch {
                ordefAdapter.items = viewModel.getListOrdsers()
            }
        }

        with(binding) {
            orderRecycler.adapter = ordefAdapter
            recyclerDiscounts.adapter = discountAdapter
            recyclerCategory.adapter = categoryAdapter
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Loading -> {
                    bindingLoading.progressBarLoadingState.visibility = View.VISIBLE
                }
                is Success -> {
                    bindingLoading.errorContainerLoadingState.visibility = View.INVISIBLE
                    bindingLoading.progressBarLoadingState.visibility = View.INVISIBLE
                    ordefAdapter.items = it.data
                }
                is Error -> {
                }
            }
        }

        categoryAdapter.onItemClickListener = { viewItem ->

            if (context?.getColor(R.color.category_default) == viewItem.tvName.textColors.defaultColor) {
                context?.let { context -> viewItem.tvName.setBackgroundColor(context.getColor(R.color.click_backgraund)) }
                context?.let { context -> viewItem.tvName.setTextColor(context.getColor(R.color.category_click)) }
            } else {
                context?.let { context -> viewItem.tvName.setBackgroundColor(context.getColor(R.color.white)) }
                context?.let { context -> viewItem.tvName.setTextColor(context.getColor(R.color.category_default)) }
            }
        }


    }

}