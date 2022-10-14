package com.owl_laugh_at_wasted_time.mytest.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.owl_laugh_at_wasted_time.mytest.R
import com.owl_laugh_at_wasted_time.mytest.databinding.FragmentMainBinding
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order
import com.owl_laugh_at_wasted_time.mytest.presentation.base.*
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.CategoryRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.DiscountRVAdapter
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters.OrderRVAdapter
import kotlinx.coroutines.launch

class MainFragment : BaseFragment(R.layout.fragment_main) {

    /*
         так как бесплатное api работает нестабильно создан список
          для имитации загрузки на случай сбоев
 */

    private val list: List<Order> = listOf(
        Order(
            id = 0,
            foodImage = "от 345 р",
            orderName = "Пицца",
            discription = "Ветчина шампиньоны \nувеличеррая порция\nтоматный соус\nсок"
        ),
        Order(
            id = 0,
            foodImage = "от 345 р",
            orderName = "Пицца",
            discription = "Ветчина шампиньоны \nувеличеррая порция\nтоматный соус\nсок"
        ),
        Order(
            id = 0,
            foodImage = "от 345 р",
            orderName = "Пицца",
            discription = "Ветчина шампиньоны \nувеличеррая порция\nтоматный соус\nсок"
        ),
        Order(
            id = 0,
            foodImage = "от 345 р",
            orderName = "Пицца",
            discription = "Ветчина шампиньоны \nувеличеррая порция\nтоматный соус\nсок"
        ),
        Order(
            id = 0,
            foodImage = "от 345 р",
            orderName = "Пицца",
            discription = "Ветчина шампиньоны \nувеличеррая порция\nтоматный соус\nсок"
        )
    )

    private val binding by viewBinding(FragmentMainBinding::bind)
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

        with(binding) {
            orderRecycler.adapter = ordefAdapter
            recyclerDiscounts.adapter = discountAdapter
            recyclerCategory.adapter = categoryAdapter
        }

        if (isOnline(requireContext())) {
            getOnLineData()
        } else {
            getCache(ordefAdapter)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Loading -> {
                    ordefAdapter.items = list
                }
                is Success -> {
                    if (it.data.size > 0) {
                        ordefAdapter.items = it.data
                        Log.d("MainFragment","${it.data.size}")
                    } else {
                        getCache(ordefAdapter)
                    }
                }
                is Error -> {
                    getCache(ordefAdapter)
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

    private fun getOnLineData() {
        viewModel.getData()
    }

    private fun getCache(ordefAdapter: OrderRVAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            val currentList = viewModel.getListOrdsers()
            if (currentList.size > 0) {
                ordefAdapter.items = currentList
            } else {
                ordefAdapter.items = list
            }
        }
    }

}