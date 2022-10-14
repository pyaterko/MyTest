package com.owl_laugh_at_wasted_time.mytest.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order
import com.owl_laugh_at_wasted_time.mytest.domain.repositorys.FoodRepository
import com.owl_laugh_at_wasted_time.mytest.presentation.base.DataLoadingState
import com.owl_laugh_at_wasted_time.mytest.presentation.base.Error
import com.owl_laugh_at_wasted_time.mytest.presentation.base.Loading
import com.owl_laugh_at_wasted_time.mytest.presentation.base.Success
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    private var _liveData = MutableLiveData<DataLoadingState<List<Order>>>()
    val liveData: LiveData<DataLoadingState<List<Order>>> = _liveData

     suspend fun getListOrdsers(): List<Order> = repository.getAllData()

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
        _liveData.value = Loading()
        viewModelScope.launch {
            val list = repository.getData()
            if (list.meals.size > 0) {
                clearCache()
                val lO = list.meals
                lO.forEach {
                    viewModelScope.launch {
                        if (it.strDescription !=null){
                            addToCache(
                                Order(
                                    id = Order.UNDEFINED_ID,
                                    foodImage = "",
                                    orderName = it.strIngredient,
                                    discription = it.strDescription
                                )
                            )
                        }

                    }
                }
                _liveData.postValue(Success(getListOrdsers()))
            } else {
                _liveData.postValue(Error(IllegalAccessException()))
            }
        }
    }
}