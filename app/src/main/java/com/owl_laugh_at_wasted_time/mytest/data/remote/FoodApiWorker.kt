package com.owl_laugh_at_wasted_time.mytest.data.remote

import javax.inject.Inject


interface FoodApiWorker {
    suspend fun getData():FoodData
}