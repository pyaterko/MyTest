package com.owl_laugh_at_wasted_time.mytest.data.remote

import retrofit2.http.GET

// https://www.themealdb.com/api/json/v1/1/list.php?i=list

interface FoodApi {
    @GET("api/json/v1/1/list.php?i=list")
    suspend fun getData():FoodData
}