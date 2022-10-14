package com.owl_laugh_at_wasted_time.mytest.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {

    @Query("SELECT * FROM food_table")
   suspend fun getAllData(): List<OrderDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: OrderDbModel)

    @Query("DELETE FROM food_table")
    suspend fun deleteAll()

}