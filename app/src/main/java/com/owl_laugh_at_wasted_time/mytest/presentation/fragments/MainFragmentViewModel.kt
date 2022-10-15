package com.owl_laugh_at_wasted_time.mytest.presentation.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order
import com.owl_laugh_at_wasted_time.mytest.domain.repositorys.FoodRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    val liveData = repository.getAllData()

    private fun addToCache(item: Order) {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    private fun clearCache() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    fun getData() {
        viewModelScope.launch {
            val list = repository.getData()
            if (list.meals.size > 0) {
                clearCache()
                val lO = list.meals
                lO.take(7)
                    .forEach {
                        addToCache(
                            Order(
                                id = Order.UNDEFINED_ID,
                                foodImage = "от 345 р",
                                orderName = it.strIngredient,
                                discription = it.strDescription
                            )
                        )
                    }

            } else {

            }
        }
    }
}