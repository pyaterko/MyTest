package com.owl_laugh_at_wasted_time.mytest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.owl_laugh_at_wasted_time.mytest.data.cache.FoodDao
import com.owl_laugh_at_wasted_time.mytest.data.cache.FoodMapper
import com.owl_laugh_at_wasted_time.mytest.data.remote.FoodApiWorker
import com.owl_laugh_at_wasted_time.mytest.data.remote.FoodData
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order
import com.owl_laugh_at_wasted_time.mytest.domain.repositorys.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val apiWorker: FoodApiWorker,
    private val mapper: FoodMapper,
    private val foodDao: FoodDao
) : FoodRepository {

    override fun getAllData(): LiveData<List<Order>> = Transformations.map(
        foodDao.getAllData()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }

    override suspend fun addItem(item: Order) {
        foodDao.addItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun deleteAll() {
        foodDao.deleteAll()
    }

    override suspend fun getData(): FoodData {
        return apiWorker.getData()
    }

}