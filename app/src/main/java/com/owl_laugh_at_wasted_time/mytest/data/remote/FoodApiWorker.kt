package com.owl_laugh_at_wasted_time.mytest.data.remote


interface FoodApiWorker {
    suspend fun getData(): FoodData
}