package com.owl_laugh_at_wasted_time.mytest.data.remote

import javax.inject.Inject

class DefaultApiWorker @Inject constructor(private val api: FoodApi) : FoodApiWorker {
    override suspend fun getData():FoodData {
        return api.getData()
    }
}