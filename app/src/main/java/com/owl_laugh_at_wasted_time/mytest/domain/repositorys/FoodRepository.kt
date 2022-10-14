package com.owl_laugh_at_wasted_time.mytest.domain.repositorys

import androidx.lifecycle.LiveData
import com.owl_laugh_at_wasted_time.mytest.data.remote.FoodData
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order

interface FoodRepository {
    fun getAllData(): LiveData<List<Order>>
    suspend fun addItem(item: Order)
    suspend fun deleteAll()
    suspend fun getData(): FoodData

}