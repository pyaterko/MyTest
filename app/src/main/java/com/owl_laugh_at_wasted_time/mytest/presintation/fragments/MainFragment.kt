package com.owl_laugh_at_wasted_time.mytest.presintation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.owl_laugh_at_wasted_time.mytest.R
import com.owl_laugh_at_wasted_time.mytest.databinding.FragmentMainBinding
import com.owl_laugh_at_wasted_time.mytest.presintation.base.viewBinding
import com.owl_laugh_at_wasted_time.mytest.presintation.fragments.adapters.CategoryRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presintation.fragments.adapters.DiscountRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presintation.fragments.adapters.OrderRVAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val discountAdapter = DiscountRVAdapter()
        val ordefAdapter = OrderRVAdapter()
        val categoryAdapter = CategoryRVAdapter()

        with(binding) {
            orderRecycler.adapter = ordefAdapter
            recyclerDiscounts.adapter = discountAdapter
            recyclerCategory.adapter = categoryAdapter
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