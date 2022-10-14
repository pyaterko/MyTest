package com.owl_laugh_at_wasted_time.mytest.data

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

    override suspend fun getAllData(): List<Order> {
        val list = foodDao.getAllData()
        return mapper.mapListDbModelToListEntity(list)
    }

    override suspend fun addItem(item: Order) {
        foodDao.addItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun deleteAll() {
        foodDao.deleteAll()
    }

    override suspend fun getData():FoodData {
        return apiWorker.getData()
    }

}